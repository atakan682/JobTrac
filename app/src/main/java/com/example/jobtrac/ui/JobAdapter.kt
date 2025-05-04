package com.example.jobtrac.ui

import android.content.Intent
import android.net.Uri
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.jobtrac.R
import com.example.jobtrac.model.JobItem

class JobAdapter(private val jobs: List<JobItem>) :
    RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.jobTitle)
        val company: TextView = view.findViewById(R.id.jobCompany)
        val location: TextView = view.findViewById(R.id.jobLocation)
        val descriptionPreview: TextView = view.findViewById(R.id.jobDescriptionPreview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_job, parent, false)

        // 🟪 Top margin fix for first item
        if (viewType == 0) {
            val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.topMargin += 16
            view.layoutParams = layoutParams
        }

        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobs[position]
        holder.title.text = job.title
        holder.company.text = job.company
        holder.location.text = job.location
        holder.descriptionPreview.text = Html.fromHtml(
            job.description ?: "",
            Html.FROM_HTML_MODE_LEGACY
        ).toString().lines().firstOrNull() ?: ""

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val message = """
                ${job.title}
                ${job.company}
                ${job.location}
                ${job.salary ?: "Salary: N/A"}

                ${Html.fromHtml(job.description ?: "", Html.FROM_HTML_MODE_LEGACY)}
            """.trimIndent()

            AlertDialog.Builder(context)
                .setTitle("Job Details")
                .setMessage(message)
                .setPositiveButton("Apply") { _, _ ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(job.url))
                    context.startActivity(intent)
                }
                .setNegativeButton("Close", null)
                .show()
        }
    }

    override fun getItemViewType(position: Int): Int = position // for top margin logic
    override fun getItemCount(): Int = jobs.size
}
