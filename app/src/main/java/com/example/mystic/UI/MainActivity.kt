package com.example.mystic.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.mystic.R


class MainActivity : AppCompatActivity() {
    val SPLASHTIMER = 5000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, SignUpActivity::class.java).also {
                startActivity(it);
                finish()
            }
        }, SPLASHTIMER.toLong())
    }
}