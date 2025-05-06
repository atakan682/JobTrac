package com.example.jobtrac

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobtrac.repo.FormRepository
import com.example.jobtrac.ui.SubmissionAdapter

class SubmissionListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission_list)

        val recyclerView = findViewById<RecyclerView>(R.id.submissionRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SubmissionAdapter(FormRepository.submittedForms)
    }
}


