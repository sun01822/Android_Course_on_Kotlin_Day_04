package com.example.form_validation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.form_validation.helper.Helper


class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var button1 : Button
    private lateinit var spinner1 : Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        onClickValidation()
    }

    private fun initialize(){
        editText1 = findViewById(R.id.firstname)
        editText2 = findViewById(R.id.lastname)
        editText3 = findViewById(R.id.email)
        editText4 = findViewById(R.id.password)
        button1 = findViewById(R.id.button1)
        spinner1 = findViewById(R.id.spinner1)
    }
    private fun onClickValidation(){
        button1.setOnClickListener {
            val email = editText3.text.toString()
            val password = editText4.text.toString()
            if(email.isEmpty()){
                editText3.setBackgroundResource(R.drawable.custom_error_background)
                Toast.makeText(this, R.string.msg1, Toast.LENGTH_SHORT).show()
            }
            else if(!Helper().isValidEmail(email)){
                editText3.setBackgroundResource(R.drawable.custom_error_background)
                Toast.makeText(this, R.string.msg3, Toast.LENGTH_SHORT).show()
            }
            else if(password.isEmpty()){
                editText3.setBackgroundResource(R.drawable.custom_background)
                editText4.setBackgroundResource(R.drawable.custom_error_background)
                Toast.makeText(this, R.string.msg2, Toast.LENGTH_SHORT).show()
            }
            else if(password.length < 8){
                editText4.setBackgroundResource(R.drawable.custom_error_background)
                Toast.makeText(this, R.string.msg4, Toast.LENGTH_SHORT).show()
            }
            else{
                editText3.setBackgroundResource(R.drawable.custom_background)
                editText4.setBackgroundResource(R.drawable.custom_background)
                val spinnerText = spinner1.selectedItem.toString()
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("FirstName", editText1.text.toString())
                intent.putExtra("LastName", editText2.text.toString())
                intent.putExtra("Email", email)
                intent.putExtra("Password", password)
                intent.putExtra("Religion", spinnerText)
                startActivity(intent)
            }
        }
    }

}