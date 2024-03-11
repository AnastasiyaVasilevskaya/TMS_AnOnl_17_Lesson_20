package com.example.domashka_19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupViewHolder(root: View) : RecyclerView.ViewHolder(root) {

    private val groupTitle: TextView = root.findViewById(R.id.group_title)

    fun bind(group: Group) {
        groupTitle.text = group.groupTitle
    }

    companion object {
        fun from(parent: ViewGroup): GroupViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val groupView = layoutInflater.inflate(R.layout.note_group, parent, false)
            return GroupViewHolder(groupView)
        }
    }
}