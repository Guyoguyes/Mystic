package com.example.mystic.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mystic.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val name = findViewById<TextView>(R.id.fullname)

        val newName = intent.getStringExtra("FULLNAME")
        name.text = newName;
    }
}