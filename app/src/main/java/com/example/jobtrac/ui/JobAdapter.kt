// File: com/example/jobtrac/ui/JobAdapter.kt
package com.example.jobtrac.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobtrac.R
import com.example.jobtrac.model.JobItem
import android.text.Html
import com.example.jobtrac.JobDetailActivity


class JobAdapter(private val jobs: List<JobItem>) :
    RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.jobTitle)
        val company: TextView = view.findViewById(R.id.jobCompany)
        val location: TextView = view.findViewById(R.id.jobLocation)
        val description: TextView = view.findViewById(R.id.jobDescription)
        val applyButton: Button = view.findViewById(R.id.applyButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_job, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobs[position]
        holder.title.text = job.title
        holder.company.text = job.company
        holder.location.text = job.location

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, JobDetailActivity::class.java).apply {
                putExtra("title", job.title)
                putExtra("company", job.company)
                putExtra("location", job.location)
                putExtra("description", job.description)
                putExtra("url", job.url)
            }
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = jobs.size
}
