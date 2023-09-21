package com.example.simplegmailclonereclyerview

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var emails: ArrayList<Email> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        val adapter = EmailAdapter(emails,
        object : EmailAdapter.ItemCLickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity,"Clicked",Toast.LENGTH_SHORT).show()
            }
        })


//        val inflater = LayoutInflater.from(this)
//        val emailItemLayout = inflater.inflate(R.layout.email_item, null)
//
//        // Access views from another_layout.xml
//        val senderTextView = emailItemLayout.findViewById<TextView>(R.id.summaryTv)
//
//        senderTextView.setOnClickListener{
//            senderTextView.setTypeface(null, Typeface.BOLD)
//        }

        emails.addAll(EmailFetcher.getEmails())
        emailsRv.adapter = adapter
        emailsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            // Fetch next 5 emails
            val newEmails = EmailFetcher.getNext5Emails()
            // Add new emails to existing list of emails
            emails.addAll(newEmails)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }

    }
}