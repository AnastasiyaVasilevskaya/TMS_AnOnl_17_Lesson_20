package com.example.domashka_19

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteViewHolder(root: View): RecyclerView.ViewHolder(root) {

    val noteTitle: TextView = root.findViewById(R.id.note_title)
    val noteText: TextView = root.findViewById(R.id.note_text)
    val noteDate: TextView = root.findViewById(R.id.note_date)
}