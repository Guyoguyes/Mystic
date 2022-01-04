package com.example.mystic.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.mystic.R
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    val SPLASHTIMER = 5000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val auth = FirebaseAuth.getInstance();

        Handler(Looper.getMainLooper()).postDelayed({
//            if(auth.currentUser != null){
//                Intent(this, HomeActivity::class.java).also {
//                    startActivity(it);
//                    finish()
//                }
//            }else{
//                Intent(this, SignUpActivity::class.java).also {
//                    startActivity(it);
//                    finish()
//                }
//            }
            Intent(this, HomeActivity::class.java).also {
                   startActivity(it);
                    finish()
               }

        }, SPLASHTIMER.toLong())
    }
}