package com.example.domashka_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domashka_19.databinding.ActivityMainBinding
import com.example.domashka_19.databinding.AddNoteDialogBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var items: MutableList<ListItem>
    private lateinit var noteAdapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.notes
        items = mutableListOf(
            Group("Покупки"),
            Note("Евроопт", "Купить 5 кг бананов", LocalDate.parse("2024-03-05")),
            Note("Рынок", "Купить 15 тюльпанов", LocalDate.parse("2024-03-05"))

        )
        noteAdapter = NoteAdapter(items)
        recyclerView.adapter = noteAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        binding.addNoteButton.setOnClickListener {
            showAddNoteDialog()
        }
    }


    private fun showAddNoteDialog() {
        val dialogBinding = AddNoteDialogBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Добавить заметку")
            .setView(dialogBinding.root)
            .setPositiveButton("Добавить") { _, _ ->
                val title = dialogBinding.dialogTitle.text.toString()
                val text = dialogBinding.dialogText.text.toString()

                val newItem = if (title.isNotEmpty()) {
                    if (text.isNotEmpty()) {
                        Note(title, text, LocalDate.now())
                    } else Group(title)
                } else null
                newItem?.let { item ->
                    items.add(item)
                    noteAdapter.notifyItemInserted(items.size - 1)
                }
            }
            .setNegativeButton("Отмена") { dialog, _ ->
                dialog.dismiss()
            }

        builder.show()
    }
}