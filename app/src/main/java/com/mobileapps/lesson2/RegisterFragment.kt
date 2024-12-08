package com.mobileapps.lesson2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.mobileapps.lesson2.LoginFragment.EventsInterface

class RegisterFragment(val credentialsManager: CredentialsManager) : Fragment() {
    private var listener: EventsInterface? = null

    interface EventsInterface {
        fun onRegisterPressed()
        fun onSwitchToLoginPressed()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        require(context is EventsInterface, {
            "Activity holding fragment must implement its EventsInterface"
        })
        listener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.register, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.nextButton).setOnClickListener {
            val emailInput = view.findViewById<TextInputLayout>(R.id.emailInput)
            val passwordInput = view.findViewById<TextInputLayout>(R.id.passwordInput)
            val numberInput = view.findViewById<TextInputLayout>(R.id.numberInput)
            val nameInput = view.findViewById<TextInputLayout>(R.id.nameInput)

            val emailText = emailInput.editText?.text.toString()
            val passwordText = passwordInput.editText?.text.toString()
            val numberText = numberInput.editText?.text.toString()
            val nameText = nameInput.editText?.text.toString()
            if (credentialsManager.checkIfEmailExists(emailText) || !credentialsManager.isEmailValid(
                    emailText
                )
            ) {
                emailInput.error = getString(R.string.email_exists_error)
            } else if (!credentialsManager.isValidPassword(passwordText)) {
                passwordInput.error = getString(R.string.bad_password_error)
            } else {
                credentialsManager.register(nameText, emailText, numberText, passwordText)
                listener?.onRegisterPressed()
            }
        }
        view.findViewById<View>(R.id.login).setOnClickListener {
            listener?.onSwitchToLoginPressed()
        }
    }

}