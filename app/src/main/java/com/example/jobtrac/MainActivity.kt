package com.example.jobtrac

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobtrac.viewmodel.JobViewModel
import com.example.jobtrac.model.JobItem
import com.example.jobtrac.ui.JobAdapter



class MainActivity : AppCompatActivity() {
    private val viewModel: JobViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.jobs.observe(this) { jobs: List<JobItem> ->
            recyclerView.adapter = JobAdapter(jobs)
        }

        viewModel.fetchJobs() // No keys required now

    }
}
