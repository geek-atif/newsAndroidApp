package com.news.app.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.news.R
import com.news.view.activity.MainActivity

/**
 * Created by Atif Qamar on 12-11-2020.
 */
class SplashActivity : AppCompatActivity() {
    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}