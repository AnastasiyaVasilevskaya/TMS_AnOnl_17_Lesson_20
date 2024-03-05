package com.example.domashka_19

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteViewHolder(root: View) : RecyclerView.ViewHolder(root) {

    private val noteTitle: TextView = root.findViewById(R.id.note_title)
    private val noteText: TextView = root.findViewById(R.id.note_text)
    private val noteDate: TextView = root.findViewById(R.id.note_date)

    fun bind(note: Note) {
        noteTitle.text = note.title
        noteText.text = note.text
        noteDate.text = note.date.toString()
    }
}