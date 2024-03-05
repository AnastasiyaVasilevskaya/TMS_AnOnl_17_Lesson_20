package com.example.domashka_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.notes)
        val notes = listOf(
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Покупки", "Купить 5 кг бананов", LocalDate.parse("2024-03-05"))

        )
        val noteAdapter = NoteAdapter(notes)
        recyclerView.adapter = noteAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}