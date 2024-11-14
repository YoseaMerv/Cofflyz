package com.example.cofflyz.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cofflyz.MainActivity
import com.example.cofflyz.R
import com.example.cofflyz.ui.login.SignUpActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonSignUp: Button
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login) // Ensure layout file is named correctly
//
//        // Initialize Firebase Auth
//        auth = FirebaseAuth.getInstance()
//
//        // Initialize UI elements
//        editTextUsername = findViewById(R.id.editTextUsername)
//        editTextPassword = findViewById(R.id.editTextPassword)
//        buttonLogin = findViewById(R.id.buttonLogin)
//        buttonSignUp = findViewById(R.id.buttonSignUp)
//        buttonBack = findViewById(R.id.buttonBack)
//
//        // Handle login button click
//        buttonLogin.setOnClickListener { loginUser() }
//
//        // Handle sign up button click
//        buttonSignUp.setOnClickListener {
//            startActivity(Intent(this, SignUpActivity::class.java))
//        }
//
//        // Handle back button click
//        buttonBack.setOnClickListener {
//            finish() // Go back to the previous screen
//        }
//    }
//
//    private fun loginUser() {
//        val email = editTextUsername.text.toString().trim()
//        val password = editTextPassword.text.toString().trim()
//
//        if (email.isEmpty() || password.isEmpty()) {
//            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        // Authenticate user with Firebase
//        auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign-in success
//                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, MainActivity::class.java) // Main activity after login
//                    startActivity(intent)
//                    finish()
//                } else {
//                    // Sign-in failed
//                    Toast.makeText(this, "Login failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
//                }
//            }
      }
}
