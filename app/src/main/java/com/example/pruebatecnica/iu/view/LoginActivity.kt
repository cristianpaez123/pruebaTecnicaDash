package com.example.pruebatecnica.iu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.ActivityLoginBinding
import com.example.pruebatecnica.databinding.ActivityMainBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()

    }

    fun onClick() {
        binding.btnLogin.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userName = binding.editInputPhone.text.toString()
                        startMainActivity(userName)
                    } else {
                        Toast.makeText(this,"error", Toast.LENGTH_SHORT)
                    }
                }
        }
    }

    private fun startMainActivity(username: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", username)
        startActivity(intent)
        finish()
    }
}