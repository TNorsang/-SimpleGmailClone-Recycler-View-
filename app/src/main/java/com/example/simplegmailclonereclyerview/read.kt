package com.example.simplegmailclonereclyerview

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type

class Read : AppCompatActivity() {

    var emails: ArrayList<Email> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_item)

        val sender = findViewById<TextView>(R.id.senderTv)

        sender.setOnClickListener{
            sender.setTypeface(null, Typeface.NORMAL)
        }

    }
}