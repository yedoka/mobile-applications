package com.mobileapps.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.mobileapps.lesson2.CredentialsManager

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val logIn = findViewById<TextView>(R.id.login)
        logIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val nextButton = findViewById<Button>(R.id.nextButton)
        val credentialsManager = CredentialsManager()
        val emailInput = findViewById<TextInputLayout>(R.id.emailInput)
        val passwordInput = findViewById<TextInputLayout>(R.id.passwordInput)
        val numberInput = findViewById<TextInputLayout>(R.id.numberInput)
        val nameInput = findViewById<TextInputLayout>(R.id.nameInput)
        nextButton.setOnClickListener{
            val emailText = emailInput.editText?.text.toString()
            val passwordText = passwordInput.editText?.text.toString()
            val numberText = numberInput.editText?.text.toString()
            val nameText = nameInput.editText?.text.toString()
            if(!credentialsManager.checkIfEmailExists(emailText)){
                credentialsManager.register(nameText,emailText,numberText,passwordText)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }else{
                emailInput.error = getString(R.string.email_exists_error)
            }
        }
    }
}
