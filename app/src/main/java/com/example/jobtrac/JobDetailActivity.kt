package com.example.jobtrac

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JobDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        val title = intent.getStringExtra("title")
        val company = intent.getStringExtra("company")
        val location = intent.getStringExtra("location")
        val description = intent.getStringExtra("description")
        val url = intent.getStringExtra("url")

        findViewById<TextView>(R.id.detailTitle).text = title
        findViewById<TextView>(R.id.detailCompany).text = company
        findViewById<TextView>(R.id.detailLocation).text = location
        findViewById<TextView>(R.id.detailDescription).text =
            Html.fromHtml(description, Html.FROM_HTML_MODE_LEGACY)

        findViewById<TextView>(R.id.detailApply).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}
