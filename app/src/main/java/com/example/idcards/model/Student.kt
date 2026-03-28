package com.example.idcards.model

data class Student(
    val name: String,
    val programme: String,
    val regNo: String,
    val issueDate: String,
    val expiryDate: String,
    val photoRes: Int
    )