package com.example.retrofit2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIEMPO:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },SPLASH_TIEMPO)
    }
}