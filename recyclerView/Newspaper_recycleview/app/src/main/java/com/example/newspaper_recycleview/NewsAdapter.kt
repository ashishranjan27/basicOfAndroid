package com.example.newspaper_recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(var list: ArrayList<String>, var context : onclick ) : RecyclerView.Adapter<viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false);
        val holder = viewholder(view)
        view.setOnClickListener {

            context.actiononclick(list[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.title.setText(list[position])
    }

}

class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title = itemView.findViewById<TextView>(R.id.title)
}
