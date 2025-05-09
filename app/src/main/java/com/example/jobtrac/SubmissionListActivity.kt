package com.example.jobtrac

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobtrac.model.SubmittedForm
import com.example.jobtrac.repo.FormRepository
import com.example.jobtrac.ui.SubmissionAdapter

class SubmissionListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission_list)

        // Load saved data from SharedPreferences
        val sharedPref = getSharedPreferences("jobtrac_data", Context.MODE_PRIVATE)
        val name = sharedPref.getString("name", null)
        val email = sharedPref.getString("email", null)
        val notes = sharedPref.getString("notes", null)

        if (!name.isNullOrEmpty() && !email.isNullOrEmpty() && !notes.isNullOrEmpty()) {
            val savedForm = SubmittedForm(name, email, notes)

            // Prevent duplicate if already in memory
            if (!FormRepository.submittedForms.contains(savedForm)) {
                FormRepository.submittedForms.add(savedForm)
            }
        }

        val recyclerView = findViewById<RecyclerView>(R.id.submissionRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SubmissionAdapter(FormRepository.submittedForms)
    }
}
