package com.mobileapps.lesson2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class FragmentSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment_sample)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<View>(R.id.changeButton).setOnClickListener {
            supportFragmentManager.commit {
                val currentFragment =
                    supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                if (currentFragment is FragmentA) {
                    replace<FragmentB>(R.id.fragmentContainerView)
                    addToBackStack(null)
                } else {
                    supportFragmentManager.popBackStack()
                }
            }
        }
    }
}