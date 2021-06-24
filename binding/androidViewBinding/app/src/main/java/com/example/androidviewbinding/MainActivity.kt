package com.example.androidviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidviewbinding.databinding.ActivityMainBinding

//it is type safe and null safe both
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //naming convention is name of the xml file in camel case removing underscore and at last add Binding in it
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //either use line 19 to 26 or 30 to 35 same output given

        /*with(binding){
            tvOutput1.text = "Hello World!"
            tvOutput2.text = "Welcome to View Binding"

            btnClickMe.setOnClickListener {
                Toast.makeText(this@MainActivity, "Hello World", Toast.LENGTH_SHORT).show()
            }
        }*/



        //this is data binding beacuse settext syntax is in java /kotlin syntax
        binding.tvOutput1.setText("Hello World!")

        //this is view binding because .text syntax is in xml only
//        binding.tvOutput1.text = "Hello World!"
        binding.tvOutput2.text = "Welcome to View Binding"

        binding.btnClickMe.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hello World", Toast.LENGTH_SHORT).show()
        }



    }
}