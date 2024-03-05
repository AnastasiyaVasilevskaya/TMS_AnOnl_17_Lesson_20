package com.example.domashka_19

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupViewHolder(root: View): RecyclerView.ViewHolder(root) {

    private val groupTitle: TextView = root.findViewById(R.id.group_title)

    fun bind(group: Group){
        groupTitle.text = group.groupTitle
    }
}