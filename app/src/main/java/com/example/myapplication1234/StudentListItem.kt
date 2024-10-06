package com.example.myapplication1234

interface StudentListItem {
    @JvmInline
    value class StudentLastName(
        val lastName: String
    ):StudentListItem
    @JvmInline
    value class Title(
        val title: String
    ):StudentListItem
}