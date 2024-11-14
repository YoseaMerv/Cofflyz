package com.example.cofflyz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import androidx.viewpager2.widget.ViewPager2

class ActivityOnboarding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // Misalnya, setelah pengguna menyelesaikan onboarding
        val buttonFinish = findViewById<Button>(R.id.sign_button)
        buttonFinish.setOnClickListener {
            // Simpan status onboarding telah ditampilkan
            val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isOnboardingShown", true)
            editor.apply()

            // Navigasi ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup OnboardingActivity agar tidak bisa kembali
        }
    }
}