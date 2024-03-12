package com.example.domashka_19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domashka_19.databinding.NoteGroupBinding

class GroupViewHolder(private val noteGroupBinding: NoteGroupBinding) :
    RecyclerView.ViewHolder(noteGroupBinding.root) {

    fun bind(group: Group) {
        noteGroupBinding.groupTitle.text = group.groupTitle
    }

    companion object {
        fun from(parent: ViewGroup): GroupViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = NoteGroupBinding.inflate(layoutInflater, parent, false)
            return GroupViewHolder(binding)
        }
    }
}