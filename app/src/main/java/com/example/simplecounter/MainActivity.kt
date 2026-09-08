package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var counter = 0
    var add = 1
    var used = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addbutton = findViewById<Button>(R.id.addbutton)
        val upgradebutton = findViewById<Button>(R.id.upgradebutton)
        val textView = findViewById<TextView>(R.id.textView)
        addbutton.setOnClickListener {
            //Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            if ((counter >= 99) && (used == 0)){
                //add = 2
                upgradebutton.visibility = View.VISIBLE
                upgradebutton.setOnClickListener {
                    add = 2
                    used = 1
                    upgradebutton.visibility = View.INVISIBLE
                    addbutton.text = "Add 2"
                }
            }
            counter += add
            textView.text = counter.toString()
        }
    }
}