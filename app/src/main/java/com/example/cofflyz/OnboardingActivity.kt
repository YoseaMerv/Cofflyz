package com.example.cofflyz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var nextButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        supportActionBar?.hide()
        setContentView(R.layout.activity_onboarding)

        // Inisialisasi ViewPager2 dan adapter
        viewPager = findViewById(R.id.viewPager)
        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        // Inisialisasi tombol
        nextButton = findViewById(R.id.finish_button)
        backButton = findViewById(R.id.back_button)

        // Menangani klik tombol "Next" untuk melanjutkan ke halaman berikutnya
        nextButton.setOnClickListener {
            if (viewPager.currentItem < 2) {
                viewPager.currentItem += 1 // Pindah ke halaman berikutnya
            } else {
                // Jika sudah di halaman terakhir, selesai onboarding
                saveOnboardingStatus(true)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }

        // Menangani klik tombol "Back" untuk kembali ke halaman sebelumnya
        backButton.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem -= 1 // Pindah ke halaman sebelumnya
            }
        }

        // Mengubah teks tombol "Next" menjadi "Sign In" pada halaman terakhir
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Jika berada di halaman ketiga, ubah tombol "Next" menjadi "Sign In"
                if (position == 2) {
                    nextButton.text = "Sign In"
                } else {
                    nextButton.text = "Next"
                }
            }
        })
    }

    private fun saveOnboardingStatus(isShown: Boolean) {
        val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isOnboardingShown", isShown)
        editor.apply() // Gunakan apply() karena asinkron dan lebih efisien
    }
}
