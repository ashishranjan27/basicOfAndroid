package com.example.recycleview_cardview.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview_cardview.Adapters.ReceipeAdapters.viewHolder
import com.example.recycleview_cardview.Models.ReceipeModel
import com.example.recycleview_cardview.R
import java.util.*


//this one have to asked ki last wala viewHolder not ReceipeAdapters.viewHolder
class ReceipeAdapters(var list: ArrayList<ReceipeModel>, var context: Context) : RecyclerView.Adapter<viewHolder>() {

    //Used to inflate
    //to show what type of structure(skeleton) you want
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        //View view = LayoutInflater.from(context).inflate(R.layout.sample_recycleview,null);
        //Can use above line also instead of lower line but can sometime have problem of having different
        //size of the image means so to remove it completely means for safe side write below one only


        //this one have to asked ki how we can say that view has type View
        val view = LayoutInflater.from(context).inflate(R.layout.sample_recycleview, parent, false)
        return viewHolder(view)
    }

    //Used to describe the strcuture of view means kaha par image , kaha par text iss type ka
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val model = list[position]
        holder.imageview.setImageResource(model.pic)
        holder.textview.text = model.text
        //Below one we do not use in general case so refer this is for understanding only and after to this is more important
        holder.imageview.setOnClickListener{
            Toast.makeText(context, "Item is clicked", Toast.LENGTH_SHORT).show() }

        /*     switch(position){
             case 0:
                 holder.imageview.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(context, "Image one is clicked", Toast.LENGTH_SHORT).show();
                     }
                 });

                 holder.textview.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(context, "Text one is displayed", Toast.LENGTH_SHORT).show();
                     }
                 });
                 break;

             case 1:
                 holder.imageview.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(context, "Image two is clicked", Toast.LENGTH_SHORT).show();
                     }
                 });

                 holder.textview.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(context, "second text is displayed", Toast.LENGTH_SHORT).show();
                     }
                 });
                 break;
             default:
         }*/
    }

    //1st called
    override fun getItemCount(): Int {
        return list.size
    }

    //adapter is used there where we have to get data from data source like in list view we have collected
    //data from array (cities ).We used built in adapter in list view but here.We will build our own adapter
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageview: ImageView
        var textview: TextView

        init {
            imageview = itemView.findViewById(R.id.imageView)
            textview = itemView.findViewById(R.id.textView)
        }
    }

}