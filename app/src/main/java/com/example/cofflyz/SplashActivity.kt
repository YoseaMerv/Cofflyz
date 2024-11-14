package com.example.cofflyz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cek apakah onboarding sudah selesai ditampilkan
        val sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)
        val isOnboardingShown = sharedPreferences.getBoolean("isOnboardingShown", false)

        // Tentukan navigasi berdasarkan status onboarding
        if (isOnboardingShown) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, ActivityOnboarding::class.java))
        }

        finish() // Tutup SplashActivity setelah navigasi
    }
}
