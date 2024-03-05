package com.example.domashka_19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notes: List<Note>) :
    RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val noteView = layoutInflater.inflate(R.layout.note_item, parent, false)
        val noteViewHolder = NoteViewHolder(noteView)
        return noteViewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.noteTitle.text = note.title
        holder.noteText.text = note.text
        holder.noteDate.text = note.date.toString()
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}