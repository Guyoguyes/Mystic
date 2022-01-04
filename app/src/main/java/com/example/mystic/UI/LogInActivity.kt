package com.example.mystic.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.mystic.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    val TAG = LogInActivity::class.qualifiedName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val emailText = findViewById<TextInputEditText>(R.id.emailText)
        val passText = findViewById<TextInputEditText>(R.id.passwordText)

        val progressBar = findViewById<CircularProgressIndicator>(R.id.signinProgressBar)
        val signInBtn = findViewById<MaterialButton>(R.id.signinBtn)

        val auth = FirebaseAuth.getInstance()

        signInBtn.setOnClickListener {
            val email = emailText.text.toString().trim();
            val password = passText.text.toString().trim();

            progressBar.visibility = View.VISIBLE
            signInBtn.visibility = View.GONE

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful){
                        Intent(this, HomeActivity::class.java).also {
                            startActivity(it)
                            finish()
                        }
                        Log.d(TAG, "signInWithEmail:success")
                    }else{
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}