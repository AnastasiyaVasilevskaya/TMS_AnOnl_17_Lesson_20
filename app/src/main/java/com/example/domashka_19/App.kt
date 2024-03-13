package com.example.domashka_19

import android.app.Application
import com.example.domashka_19.data.NotesService

class App: Application() {

    val notesService = NotesService()
}