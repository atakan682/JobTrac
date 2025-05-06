package com.example.jobtrac

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val nameInput = findViewById<EditText>(R.id.inputName)
        val emailInput = findViewById<EditText>(R.id.inputEmail)
        val notesInput = findViewById<EditText>(R.id.inputNotes)
        val submitBtn = findViewById<Button>(R.id.submitButton)

        submitBtn.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val notes = notesInput.text.toString().trim()

            // You can save this info to ViewModel, API, or local database
            Toast.makeText(this, "Application submitted!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
