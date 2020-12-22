package com.devdossantos.sofie.main.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devdossantos.sofie.R
import com.devdossantos.sofie.main.model.TodoModel

class MainViewHolder(
    view: View
) : RecyclerView.ViewHolder(view){
    private val title = view.findViewById<TextView>(R.id.txt_todoTitle_item)
    private val email = view.findViewById<TextView>(R.id.txt_todoMail_item)
    private val description = view.findViewById<TextView>(R.id.txt_todoDescription_item)

    fun bind (item: TodoModel) {
        title.text = item.title
        email.text = item.email
        description.text = item.description
    }

}
