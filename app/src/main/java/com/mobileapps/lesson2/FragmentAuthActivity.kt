package com.mobileapps.lesson2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class FragmentAuthActivity :

    AppCompatActivity(R.layout.activity_fragment_auth), LoginFragment.EventsInterface,
    RegisterFragment.EventsInterface {
    private val credentialsManager = CredentialsManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment_auth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.commit {
            val fragment = RegisterFragment(credentialsManager)
            replace(R.id.fragmentContainerView, fragment)
        }

    }

    override fun onLoginPressed() {
        supportFragmentManager.commit {
            replace<MainFragment>(R.id.fragmentContainerView)
            addToBackStack(null)
        }
    }

    override fun onRegisterPressed() {
        supportFragmentManager.commit {
            val fragment = LoginFragment(credentialsManager)
            replace(R.id.fragmentContainerView, fragment)
            addToBackStack(null)
        }
    }

    override fun onSwitchToLoginPressed() {
        supportFragmentManager.commit {
            val fragment = LoginFragment(credentialsManager)
            replace(R.id.fragmentContainerView, fragment)
            addToBackStack(null)
        }
    }

    override fun onSwitchToRegisterPressed() {
        supportFragmentManager.commit {
            val fragment = RegisterFragment(credentialsManager)
            replace(R.id.fragmentContainerView, fragment)
            addToBackStack(null)
        }
    }
}

