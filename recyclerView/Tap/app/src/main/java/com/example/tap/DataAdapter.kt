package com.example.tap

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(val itemList: List<Data>, click: Clicked):RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    //either you can remove line no 15 and in constructor pass a property not variable means var click:Clicked and instead of check write click in line no 29
    var check:Clicked = click;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.frame.setOnClickListener{
                check.clickOnPosition(position)

               for(i in 0 .. itemList.size-1)
               {
                    if(i!=position && itemList[i].isSelected==false)
                    {
                        itemList[i].isSelected = false
                        holder.frame.setBackgroundResource(R.drawable.cart_navigation_unselected)
                        holder.title.setTextColor(Color.parseColor("#FF000000"))
                        holder.title.text = itemList[position].text
                        holder.cross.visibility = View.GONE
                    }

               }
        }

        if(itemList[position].isSelected == true)
        {
            holder.frame.setBackgroundResource(R.drawable.cart_navigation_selected)
            holder.title.setTextColor(Color.parseColor("#FFFFFFFF"))
            holder.title.text = itemList[position].text
            holder.cross.visibility = View.VISIBLE
            holder.cross.text = itemList[position].cross
            holder.cross.setTextColor(Color.parseColor("#FFFFFFFF"))
        }
        else
        {
            holder.frame.setBackgroundResource(R.drawable.cart_navigation_unselected)
            holder.title.setTextColor(Color.parseColor("#FF000000"))
            holder.title.text = itemList[position].text
            holder.cross.visibility = View.GONE
        }

    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var title: TextView = itemView.findViewById(R.id.tv_title)
        var frame: LinearLayout =itemView.findViewById(R.id.frame)
        var cross: TextView = itemView.findViewById(R.id.cross)
    }

}


interface Clicked{
    fun clickOnPosition( index: Int)
}





//public class ViewHolder extends RecyclerView.ViewHolder {
//
//    RecyclerView recyclerView;
//    TextView tvHeading;
//
//    public ViewHolder(View itemView) {
//        super(itemView);
//
//        recyclerView = (RecyclerView) itemView.findViewById(R.id.rvChapters);
//        tvHeading = (TextView) itemView.findViewById(R.id.tvSubjectName);
//    }
//}


