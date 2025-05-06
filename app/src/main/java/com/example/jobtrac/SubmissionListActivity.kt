package com.example.jobtrac

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.jobtrac.viewmodel.JobViewModel
import com.example.jobtrac.model.SubmittedForm


class SubmissionListActivity : AppCompatActivity() {
    private val viewModel: JobViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission_list)

        val textView = findViewById<TextView>(R.id.submissionListText)

        viewModel.submittedForms.observe(this) { list: List<SubmittedForm> ->
        val displayText = list.joinToString("\n\n") {
                "Name: ${it.name}\nEmail: ${it.email}\nNotes: ${it.notes}"
            }
            textView.text = displayText.ifEmpty { "No submissions yet." }
        }
    }
}
