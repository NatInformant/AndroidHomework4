package com.example.myapplication1234.utils

import com.example.myapplication1234.models.LessonListItem
import com.example.myapplication1234.models.ScheduleListItem

object ScheduleDataUtils {
    private val weekSchedule =
        mapOf<ScheduleListItem.DayTitleListItem, List<ScheduleListItem>>(
            Pair(
                ScheduleListItem.DayTitleListItem("Понедельник"),
                listOf(
                    LessonListItem("Базы Данных (Лек)", "18:20-19:50"),
                    LessonListItem("Базы Данных (Пр)", "19:55-21:25"),
                )
            ),
            Pair(
                ScheduleListItem.DayTitleListItem("Вторник"),
                listOf(
                    LessonListItem("Управление IT-проектами и ЖЦ ПО (Лек)", "18:20-19:50"),
                    LessonListItem("Управление IT-проектами и ЖЦ ПО (Пр)", "19:55-21:25"),
                )
            ),
            Pair(
                ScheduleListItem.DayTitleListItem("Среда"),
                listOf()
            ),
            Pair(
                ScheduleListItem.DayTitleListItem("Четверг"),
                listOf(
                    LessonListItem("Разработка интернет приложений (Лек)", "19:30-19:50"),
                    LessonListItem("Разработка интернет приложений (Пр)", "19:55-21:25"),
                )
            ),
            Pair(
                ScheduleListItem.DayTitleListItem("Пятница"),
                listOf(
                    LessonListItem("Экономика программной инженерии (Пр)", "13:15-14:45"),
                    LessonListItem("Экономика программной инженерии (Лек)", "15:00-16:30"),
                    LessonListItem("Экономика программной инженерии (Пр)", "16:40-18:10"),
                    LessonListItem("Тестирование ПО (Лек)", "19:30-21:00"),
                )
            )
        )
    val weekScheduleList = weekSchedule.flatMap {
        getDayScheduleFromThisPair(it.toPair())
    }

    private fun getDayScheduleFromThisPair(pair: Pair<ScheduleListItem.DayTitleListItem, List<ScheduleListItem>>): List<ScheduleListItem> {
        val resultDaySchedule = mutableListOf<ScheduleListItem>()

        resultDaySchedule.add(pair.first)

        if (pair.second.isEmpty()) {
            resultDaySchedule.add(LessonListItem("Ничего в этот день нету", ""))
        } else {
            resultDaySchedule.addAll(pair.second)
        }

        return resultDaySchedule
    }

    fun getScheduleForThisDay(): List<ScheduleListItem> {
        return getDayScheduleFromThisPair(weekSchedule.entries.find { it.key.title == "Среда" }!!.toPair())
    }
}