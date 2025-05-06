package com.example.jobtrac.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobtrac.R
import com.example.jobtrac.model.SubmittedForm

class SubmissionAdapter(private val submissions: List<SubmittedForm>) :
    RecyclerView.Adapter<SubmissionAdapter.SubmissionViewHolder>() {

    class SubmissionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.submissionName)
        val email: TextView = view.findViewById(R.id.submissionEmail)
        val notes: TextView = view.findViewById(R.id.submissionNotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubmissionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_submission, parent, false)
        return SubmissionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubmissionViewHolder, position: Int) {
        val form = submissions[position]
        holder.name.text = "Name: ${form.name}"
        holder.email.text = "Email: ${form.email}"
        holder.notes.text = "Notes: ${form.notes}"
    }

    override fun getItemCount(): Int = submissions.size
}

