package com.devdossantos.sofie.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.devdossantos.sofie.MainActivity
import com.devdossantos.sofie.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        logoAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, HANDLER_TIME)
    }

    private fun logoAnimation() {
        val logo1 = findViewById<ImageView>(R.id.image_logo1_splash)

        logo1.animate().apply {
            duration = 500
            alpha(1f)
        }

        logo1.animate().apply {
            duration = HANDLER_TIME
            scaleY(1.2f)
            scaleX(1.2f)
        }

    }

    companion object {
        const val HANDLER_TIME: Long = 5000
    }
}