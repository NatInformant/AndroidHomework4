package com.example.myapplication1234.models

data class LessonListItem(
    val lessonName: String,
    val lessonTime: String,
    val lessonTeacher: String,
    val lessonAuditorium: String
) : ScheduleListItem
