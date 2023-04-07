package com.example.prac12asize
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


import java.text.SimpleDateFormat

import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            val editTextDate = findViewById<EditText>(R.id.editTextDate)
            val dateStr = editTextDate.text.toString()

            if (dateStr.isNotEmpty()) {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val date = dateFormat.parse(dateStr)

                if (date != null) {
                    val calendar = Calendar.getInstance()
                    calendar.time = date
                    val dayOfWeek = calendar.getDisplayName(
                        Calendar.DAY_OF_WEEK,
                        Calendar.LONG,
                        Locale.getDefault()
                    )

                    val month = calendar.get(Calendar.MONTH)
                    val season = when (month) {
                        in 2..4 -> "Весна"
                        in 5..7 -> "Лето"
                        in 8..10 -> "Осень"
                        else -> "Зима"
                    }

                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("dayOfWeek", dayOfWeek)
                    intent.putExtra("season", season)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Неправильный формат даты", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Введите дату, чтоб продолжить", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


