package com.example.mystic.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import com.example.mystic.Model.User
import com.example.mystic.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap

class SignUpActivity : AppCompatActivity() {

    val TAG = SignUpActivity::class.qualifiedName



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_sign_up)

        var fullNameText = findViewById<EditText>(R.id.fullNameText)
        var emailText = findViewById<EditText>(R.id.emailText)
        var passwordText = findViewById<EditText>(R.id.passwordText)

        val signUpBtn = findViewById<MaterialButton>(R.id.signupBtn)

        signUpBtn.setOnClickListener {
            var fullName = fullNameText.text.toString()
            var email = emailText.text.toString()
            var password = passwordText.text.toString()

            if(fullName.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all inputs!!", Toast.LENGTH_LONG).show()
            }else{
                val auth = FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            createUser(fullName, email, password)
                            Intent(this, HomeActivity::class.java).also {
                                it.putExtra("FULLNAME", fullName)
                                it.putExtra("EMAIL", email)
                                startActivity(it)
                            }
                            Log.d(TAG, "User registered successfully")
                        }else{
                            val message = task.exception!!.toString()
                            Log.w(TAG, "Error authentication", task.exception)
                        }
                    }
            }
        }
    }

    private fun createUser(fullName: String, email: String, password: String) {
        val db = FirebaseFirestore.getInstance();

       val user = HashMap<String, User>();
        val userInfo = User(fullName, email, password)
        user.set("user", userInfo)

        db.collection("Users")
            .add(user)
            .addOnSuccessListener {
                Log.d(TAG, "user added to db")
            }
            .addOnFailureListener{
                Log.e(TAG, "user not added to DB")
            }
    }
}