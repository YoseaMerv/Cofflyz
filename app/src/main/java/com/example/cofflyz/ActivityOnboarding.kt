package com.example.cofflyz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2


class ActivityOnboarding : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var backButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        backButton = findViewById(R.id.back_button)
        nextButton = findViewById(R.id.next_button)

        // Inisialisasi adapter untuk ViewPager2
        val adapter = OnboardingAdapter(this)
        viewPager.adapter = adapter

        // Tampilkan tombol "Back" hanya setelah halaman pertama
        backButton.visibility = View.GONE

        // Navigasi tombol "Next"
        nextButton.setOnClickListener {
            if (viewPager.currentItem < adapter.itemCount - 1) {
                viewPager.currentItem += 1
            } else {
                finishOnboarding()
            }
        }

        // Navigasi tombol "Back"
        backButton.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem -= 1
            }
        }

        // Mengontrol tampilan tombol berdasarkan halaman saat ini
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                backButton.visibility = if (position == 0) View.GONE else View.VISIBLE
                nextButton.text = if (position == adapter.itemCount - 1) "Finish" else "Next"
            }
        })
    }

    private fun finishOnboarding() {
        // Simpan status onboarding telah selesai
        val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isOnboardingShown", true)
        editor.apply()

        // Pindah ke MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
