package com.example.androidviewbindingfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidviewbindingfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //note all id here in camel case removing space in between them
        with(binding){
            tvOutput1.text = "Hello World!"
            //made nullable because in landscape it is not present
            tvOutput2?.text = "Welcome to View Binding"
            includedLayout?.tvIncludeOutput1?.text = "View Binding in Included layout..."

            btnClickMe.setOnClickListener {
                val fragment = MainFragment()

                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit()
            }
        }
    }
}