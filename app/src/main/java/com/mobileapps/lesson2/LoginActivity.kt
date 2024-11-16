package com.mobileapps.lesson2

import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    private val emailInputLayout: TextInputLayout by lazy { findViewById(R.id.emailInputLayout) }
    private val emailEditText: TextInputEditText by lazy { findViewById(R.id.emailEditText) }
    private val passwordInputLayout: TextInputLayout by lazy { findViewById(R.id.passwordInputLayout) }
    private val passwordEditText: TextInputEditText by lazy { findViewById(R.id.passwordEditText) }
    private val nextButton: Button by lazy { findViewById(R.id.nextButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        nextButton.setOnClickListener { validateAndLogin() }
    }

    private fun validateAndLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()

        var isValid = true

        if (!credentialsManager.isEmailValid(email)) {
            emailInputLayout.error = "Invalid email format"
            isValid = false
        } else {
            emailInputLayout.error = null
        }

        if (!credentialsManager.isValidPassword(password)) {
            passwordInputLayout.error = "Password cannot be empty"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }

    }
}
