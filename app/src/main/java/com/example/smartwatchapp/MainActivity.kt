package com.example.smartwatchapp

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()
        var fin = findViewById<Button>(R.id.btnFinance)
        fin.setOnClickListener{
            val intent = Intent(this, FinanceActivity::class.java)
            startActivity(intent)
        }
    }
}
