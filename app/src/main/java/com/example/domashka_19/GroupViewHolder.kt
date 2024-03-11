package com.example.domashka_19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domashka_19.databinding.NoteItemBinding

class GroupViewHolder(private val noteGroupBinding: NoteItemBinding) :
    RecyclerView.ViewHolder(noteGroupBinding.root) {

    fun bind(group: Group) {
        noteGroupBinding.noteTitle.text = group.groupTitle
    }

    companion object {
        fun from(parent: ViewGroup): GroupViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = NoteItemBinding.inflate(layoutInflater, parent, false)
            return GroupViewHolder(binding)
        }
    }
}