package com.example.memesharing

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun volley(){
        val imageView : ImageView = findViewById(R.id.imageView);
        val queue = Volley.newRequestQueue(this)
        val url =  "https://meme-api.herokuapp.com/gimme"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
              //  Log.d("Ashish","ohno")
                 val url = response.getString("url");
                Glide.with(this).load(url).into(imageView);
                //Log.d("Ashish","ohno")
            },
            Response.ErrorListener { error ->
                 Toast.makeText(this,"Wrong", Toast.LENGTH_SHORT).show()
            }
        )
        queue.add(jsonObjectRequest);

    }

    fun nextMeme(view: View) {

    }

    fun shareMeme(view: View) {

    }
}