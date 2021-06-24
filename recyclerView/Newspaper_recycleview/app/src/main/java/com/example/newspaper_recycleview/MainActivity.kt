package com.example.newspaper_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TokenWatcher
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() ,onclick{

    var list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data()
        var adapter = NewsAdapter(list,this);
        val recycleview = findViewById<RecyclerView>(R.id.recycleview);
        recycleview.adapter=adapter
        //recycleview.(adapter)
        recycleview.layoutManager= LinearLayoutManager(this)
    }
    fun data()
    {

        for(i in 0..12){
            list.add("He is no ${i} in good morning")
        }
    }

    override fun actiononclick(name:String) {
        Toast.makeText(this,"Ashish Ranjan",Toast.LENGTH_SHORT).show()
    }
}