package com.example.domashka_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var items: MutableList<ListItem>
    private lateinit var noteAdapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.notes)
        items = mutableListOf(
            Group("Покупки"),
            Note("Евроопт", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Рынок", "Купить 15 тюльпанов", LocalDate.parse("2024-03-05"))

        )
        noteAdapter = NoteAdapter(items)
        recyclerView.adapter = noteAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        findViewById<AppCompatButton>(R.id.add_note_button).setOnClickListener {
            showAddNoteDialog()
        }
    }


    private fun showAddNoteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Добавить заметку")

        val dialogView = LayoutInflater.from(this).inflate(R.layout.add_note_dialog, null)
        val titleEditText = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val textEditText = dialogView.findViewById<EditText>(R.id.editTextText)

        builder.setView(dialogView)

        builder.setPositiveButton("Добавить") { _, _ ->
            val title = titleEditText.text.toString()
            val text = textEditText.text.toString()

            if (title.isNotEmpty() && text.isNotEmpty()) {
                val newNote = Note(title, text, LocalDate.now())
                items.add(newNote)
                noteAdapter.notifyItemInserted(items.size - 1)
            }
            if (title.isNotEmpty() && text.isEmpty()) {
                val newGroup = Group(title)
                items.add(newGroup)
                noteAdapter.notifyItemInserted(items.size - 1)
            }
        }

        builder.setNegativeButton("Отмена") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }
}