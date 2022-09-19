package com.example.pruebatecnica.iu.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebatecnica.databinding.ActivityLoginBinding
import com.example.pruebatecnica.iu.viewModel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    lateinit var binding: ActivityLoginBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logIn()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.resultLogin().observe(
            this
        ) { state ->
            when (state) {
                is LoginViewModel.GetResultLoginState.SuccessLogin -> {
                        startMainActivity()
                }
                is LoginViewModel.GetResultLoginState.Error -> {
                    Toast.makeText(this, state.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun logIn(){
        binding.btnLogin.setOnClickListener {
            var email = binding.editInputEmail.text.toString()
            var password = binding.editInputPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                viewModel.getResultLogin(email,password)
            }else{
                showAlert()
            }
        }
    }
    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("ingrese correo o contraseña validos")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}