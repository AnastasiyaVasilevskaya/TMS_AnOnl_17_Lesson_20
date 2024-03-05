package com.example.domashka_19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalStateException

class NoteAdapter(private val items: List<ListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return when (item) {
            is Note -> NOTE_TYPE
            is Group -> GROUP_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == NOTE_TYPE) {
            val noteView = layoutInflater.inflate(R.layout.note_item, parent, false)
            NoteViewHolder(noteView)
        } else {
            val groupView = layoutInflater.inflate(R.layout.note_group, parent, false)
            GroupViewHolder(groupView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (item is Note && holder is NoteViewHolder) {
            holder.bind(item)
        } else if (item is Group && holder is GroupViewHolder) {
            holder.bind(item)
        } else {
            throw IllegalStateException()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    companion object {
        private const val NOTE_TYPE = 1
        private const val GROUP_TYPE = 2
    }
}