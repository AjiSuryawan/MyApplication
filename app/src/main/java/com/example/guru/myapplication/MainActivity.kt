package com.example.guru.myapplication
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    var emailText: EditText? = null
    var passwordText: EditText? = null
    var loginButton: Button? = null
    var signupLink: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton = findViewById(R.id.btn_login) as Button
        signupLink = findViewById(R.id.link_signup) as TextView
        passwordText = findViewById(R.id.input_password) as EditText
        emailText = findViewById(R.id.input_email) as EditText
        loginButton!!.setOnClickListener(View.OnClickListener {
            if (emailText!!.text.toString().equals("admin") && passwordText!!.text.toString().equals("admin"))
            {
                Toast.makeText(applicationContext, "makanan", Toast.LENGTH_SHORT).show()
                //val intent = Intent(applicationContext, Kalkulator::class.java)
                val intent = Intent(applicationContext, Main2Activity::class.java)
                startActivity(intent)
                this.finish()
            }else{
                Toast.makeText(applicationContext, "gagal Login", Toast.LENGTH_SHORT).show()
            }
        })
    }
}