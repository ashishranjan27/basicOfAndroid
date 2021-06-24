package com.example.tap

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), Clicked {
    val itemList = ArrayList<Data>()
    lateinit var rcv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchData()
        rcv = findViewById(R.id.rcv)
        //rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcv.adapter = DataAdapter(itemList,this)
    }

    fun fetchData(){
        for (i in 1..6) {
            var obj = Data("Urban ", "X", false)
            itemList.add(obj)
        }
    }

   // override fun clickOnPosition(index: Int) {

//    }

    override fun clickOnPosition(index: Int) {
//        itemList[index].text ="ASASa"

        if (itemList[index].isSelected == false) {
            for(i in 0 .. itemList.size -1)
            {
                if(i!=index && itemList[i].isSelected==true)
                {
                    itemList[i].isSelected = false
                }
            }
            itemList[index].isSelected = true
            (rcv.adapter as DataAdapter).notifyDataSetChanged()
        }
        else if(itemList[index].isSelected == true)
        {
            itemList[index].isSelected = false
           // (rcv.adapter as DataAdapter).notifyItemChanged(index);
            (rcv.adapter as DataAdapter).notifyDataSetChanged()
        }
    }
}