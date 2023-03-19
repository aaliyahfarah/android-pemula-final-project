package com.dicoding.mbtiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivitySplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity_main)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this@MainActivitySplash, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}