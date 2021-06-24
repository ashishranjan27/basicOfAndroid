package com.example.recycleview_cardview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview_cardview.Adapters.ReceipeAdapters
import com.example.recycleview_cardview.Models.ReceipeModel
import java.util.*

class MainActivity : AppCompatActivity() {
    //this one have to asked about the lateinit
    lateinit  var recycle: RecyclerView
  //  var recycle: RecyclerView? = null

    //this one have to asked ? in bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycle = findViewById(R.id.recycle_view)

        //Uncomment below line of code and comment the same given two line written below
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //recycle.setLayoutManager(layoutManager);
        val list = ArrayList<ReceipeModel>()
        list.add(ReceipeModel(R.drawable.food1, "Burger"))
        list.add(ReceipeModel(R.drawable.food2, "Burger"))
        list.add(ReceipeModel(R.drawable.food3, "Burger"))
        list.add(ReceipeModel(R.drawable.food4, "Burger"))
        list.add(ReceipeModel(R.drawable.food5, "Burger"))
        list.add(ReceipeModel(R.drawable.food6, "Burger"))
        list.add(ReceipeModel(R.drawable.food7, "Burger"))
        list.add(ReceipeModel(R.drawable.food8, "Burger"))
        list.add(ReceipeModel(R.drawable.food9, "Burger"))
        val adapter = ReceipeAdapters(list, this)
        recycle.setAdapter(adapter)

        //Move from top to bottom
        val layoutManager = LinearLayoutManager(this)
        recycle.setLayoutManager(layoutManager)

        //Move from right to left
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        //recycle.setLayoutManager(layoutManager);

        //Move from left to right
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true);
        //recycle.setLayoutManager(layoutManager);

        //  GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //recycle.setLayoutManager(gridLayoutManager);

        //StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //recycle.setLayoutManager(staggered);

        //StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        //recycle.setLayoutManager(staggered);
    }
}