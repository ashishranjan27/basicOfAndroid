package com.example.firebasecrashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            crashnow()
        })
    }

    private fun crashnow() {
        throw RuntimeException("App crashed")
      //  Toast.makeText(this,"my name is",Toast.LENGTH_SHORT).show()
    }
}