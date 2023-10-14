package com.example.uts_movieticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intentToLoginPage = Intent(this@SplashScreen, LoginPage::class.java)
            startActivity(intentToLoginPage)
            finish()
        },2000)
    }
}