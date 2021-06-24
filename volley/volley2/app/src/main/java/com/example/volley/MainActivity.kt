package com.example.volley

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    private var mTextViewResult: TextView? = null
    private var mQueue: RequestQueue? = null
    private var buttonParse:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextViewResult = findViewById(R.id.text_view_result)
        buttonParse = findViewById(R.id.button_parse)
        mQueue = Volley.newRequestQueue(this)
        buttonParse?.setOnClickListener { jsonParse() }
    }

    private fun jsonParse() {
        val url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    try {
                        val jsonArray = response.getJSONArray("hits")
                        for (i in 0..jsonArray.length()) {
                            val employee = jsonArray.getJSONObject(i)
                            val firstname = employee.getString("tags")
                            val age = employee.getInt("likes")
                            val mail = employee.getString("type")
                            mTextViewResult!!.append("$firstname, $age, $mail\n\n")
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener { error -> error.printStackTrace() })
        mQueue!!.add(request)
    }
}