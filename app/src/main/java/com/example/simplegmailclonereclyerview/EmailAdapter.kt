package com.example.simplegmailclonereclyerview

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>,val listener : ItemCLickListener) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    interface ItemCLickListener {
        fun onItemClick(position: Int);
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.email_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails.get(position)
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary


        holder.itemView.setOnClickListener {
            holder.senderTextView.setTypeface(null, Typeface.NORMAL)
            listener.onItemClick(position)
        }
    }
}