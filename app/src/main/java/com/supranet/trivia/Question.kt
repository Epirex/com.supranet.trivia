package com.supranet.trivia

data class Question(
    val id: Int,
    val questionText: String,
    val image: Int?,
    val alternatives: List<String>,
    val correctAnswerIndex: Int,
)
