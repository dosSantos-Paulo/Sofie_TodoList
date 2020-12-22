package com.devdossantos.sofie.view.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.devdossantos.sofie.view.MainActivity
import com.devdossantos.sofie.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        logoAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, HANDLER_TIME)
    }

    private fun logoAnimation() {
        val logo1 = findViewById<ImageView>(R.id.image_logo1_splash)

        logo1.animate().apply {
            duration = SHOW_ANIMATION_DURATION
            alpha(SHOW_ANIMATION_ALPHA)
        }

        logo1.animate().apply {
            duration = HANDLER_TIME
            scaleY(FINAL_SIZE_ANIMATION)
            scaleX(FINAL_SIZE_ANIMATION)
        }

    }

    companion object {
        const val HANDLER_TIME: Long = 5000
        const val FINAL_SIZE_ANIMATION: Float = 1.2F
        const val SHOW_ANIMATION_DURATION: Long = 500
        const val SHOW_ANIMATION_ALPHA: Float = 1F
    }
}