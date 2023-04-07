package com.example.prac12asize

import android.graphics.Color
import android.os.Bundle

import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val relativeLayout = findViewById<RelativeLayout>(R.id.relativeLayout)
        val textViewDayOfWeek = findViewById<TextView>(R.id.textViewDayOfWeek)
        val textViewSeason = findViewById<TextView>(R.id.textViewSeason)

        val dayOfWeek = intent.getStringExtra("dayOfWeek")
        val season = intent.getStringExtra("season")

        textViewDayOfWeek.text = "День недели: $dayOfWeek"
        textViewSeason.text = "Сезон: $season"

        when (season) {
            "Весна" -> relativeLayout.setBackgroundColor(Color.CYAN)
            "Лето" -> relativeLayout.setBackgroundColor(Color.GREEN)
            "Осень" -> relativeLayout.setBackgroundColor(Color.YELLOW)
            else -> relativeLayout.setBackgroundColor(Color.BLUE)
        }
    }
}


