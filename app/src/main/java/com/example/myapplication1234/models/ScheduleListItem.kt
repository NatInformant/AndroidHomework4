package com.example.myapplication1234.models

interface ScheduleListItem {
    @JvmInline
    value class DayTitleListItem(
        val dayOfWeek: MyDayOfWeek
    ): ScheduleListItem
}