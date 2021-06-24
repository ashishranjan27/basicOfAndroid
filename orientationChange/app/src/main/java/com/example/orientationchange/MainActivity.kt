package com.example.orientationchange

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var decrement: Button
    lateinit var increment: Button
    lateinit var textView: TextView
    private var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decrement = findViewById(R.id.decrement)
        increment = findViewById(R.id.increment)
        textView = findViewById(R.id.textview)
        decrement.setOnClickListener(View.OnClickListener {
            num--
            if (num < 0) {
                num = 0
            }
            textView.setText(num.toString())
        })
        increment.setOnClickListener(View.OnClickListener {
            num++
            textView.setText(num.toString())
        })

       /* if (savedInstanceState != null) {
            num = savedInstanceState.getInt("count");
//            textView.setText(String.valueOf(num));
            textView.setText(num.toString())
        }*/
        //either this or line 47 to 51
    }

    //saving the instance
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", num)
    }

    //geeting the value of the saved instance
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        num = savedInstanceState.getInt("count")
        textView!!.text = num.toString()
    }
}
