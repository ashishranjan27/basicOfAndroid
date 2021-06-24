package com.example.coroutinefirstprogram

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        var imageView = findViewById<ImageView>(R.id.imageView)

        button.setOnClickListener {
          //  View.OnClickListener {

                CoroutineScope(Dispatchers.Main).launch {
                    try {
                        Log.d("MyTag", "onCreate: ThreadName: ${Thread.currentThread().name}")
                        val url = URL("https://i.redd.it/bfc0pz8qdji61.jpg")
                        val bitmap = BitmapFactory.decodeStream(url.openStream())

                        withContext(Dispatchers.Main) {
                            Log.d(
                                "MyTag",
                                "onCreate withContext: ThreadName: ${Thread.currentThread().name}"
                            )
                            imageView.setImageBitmap(bitmap)
                        }
                    } catch (e: Exception) {
                        Log.d("MyTag", "onCreate: ${e}")
                    }
                }
            }
       // }
    }
}