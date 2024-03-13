package com.example.domashka_19.data

import java.time.LocalDate

data class Note(
    val title: String,
    val text: String,
    val date: LocalDate
) : ListItem