package com.example.coordinatorlayout_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coordinator)
        val btnLayoutBased: AppCompatButton = findViewById(R.id.btnLayoutBased)
        val btnScrollBased: AppCompatButton = findViewById(R.id.btnScrollBased)
        btnLayoutBased.setOnClickListener {
            startActivity(Intent(this, LayoutBasedActivity::class.java))
        }

        btnScrollBased.setOnClickListener {
            startActivity(Intent(this, ScrollBasedActivity::class.java))
        }
    }

}