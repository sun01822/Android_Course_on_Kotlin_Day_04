package com.example.form_validation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var textView1 : TextView
    private lateinit var textView2 : TextView
    private lateinit var textView3 : TextView
    private lateinit var textView4 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initialize()
        val firstName = intent.getStringExtra("FirstName")
        val lastName = intent.getStringExtra("LastName")
        val email = intent.getStringExtra("Email")
        val password = intent.getStringExtra("Password")
        val religion = intent.getStringExtra("Religion")

        textView1.text = "$firstName" + " " + "$lastName"
        textView2.text = email
        textView3.text = password
        textView4.text = religion

    }

    private fun initialize(){
        textView1 = findViewById(R.id.name)
        textView2 = findViewById(R.id.email)
        textView3 = findViewById(R.id.password)
        textView4 = findViewById(R.id.religion)
    }
}