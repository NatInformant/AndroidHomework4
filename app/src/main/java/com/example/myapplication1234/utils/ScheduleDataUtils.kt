package com.example.myapplication1234.utils

import com.example.myapplication1234.models.LessonListItem
import com.example.myapplication1234.models.MyDayOfWeek
import com.example.myapplication1234.models.ScheduleListItem
import java.time.LocalDate

object ScheduleDataUtils {
    private val weekSchedule =
        mapOf<ScheduleListItem.DayTitleListItem, List<ScheduleListItem>>(
            Pair(
                ScheduleListItem.DayTitleListItem(MyDayOfWeek.MONDAY),
                listOf(
                    LessonListItem("Базы Данных (Лек)", "18:20-19:50", "Барабанщиков С.А.", "А-13"),
                    LessonListItem("Базы Данных (Пр)", "19:55-21:25", "Барабанщиков С.А.", "А-13"),
                )
            ),
            Pair(
                ScheduleListItem.DayTitleListItem(MyDayOfWeek.TUESDAY),
                listOf(
                    LessonListItem(
                        "Управление IT-проектами и ЖЦ ПО (Лек)",
                        "18:20-19:50",
                        "Владислав Воробьёв",
                        "А-21"
                    ),
                    LessonListItem(
                        "Управление IT-проектами и ЖЦ ПО (Пр)",
                        "19:55-21:25",
                        "Владислав Воробьёв",
                        "А-21"
                    ),
                )
            ),
            Pair(
                ScheduleListItem.DayTitleListItem(MyDayOfWeek.WEDNESDAY),
                listOf()
            ),
            Pair(
                ScheduleListItem.DayTitleListItem(MyDayOfWeek.THURSDAY),
                listOf(
                    LessonListItem(
                        "Разработка интернет приложений (Лек)",
                        "19:30-19:50",
                        "Евгений Повлеченков",
                        "132"
                    ),
                    LessonListItem(
                        "Разработка интернет приложений (Пр)",
                        "19:55-21:25",
                        "Евгений Повлеченков",
                        "132"
                    ),
                )
            ),
            Pair(
                ScheduleListItem.DayTitleListItem(MyDayOfWeek.FRIDAY),
                listOf(
                    LessonListItem("Экономика программной инженерии (Пр)", "13:15-14:45","Преподаватель","212"),
                    LessonListItem("Экономика программной инженерии (Лек)", "15:00-16:30", "Преподаватель","212"),
                    LessonListItem("Экономика программной инженерии (Пр)", "16:40-18:10", "Преподаватель","212"),
                    LessonListItem("Тестирование ПО (Лек)", "19:30-21:00", "Преподаватель","212"),
                )
            ),
            Pair(
                ScheduleListItem.DayTitleListItem(MyDayOfWeek.SATURDAY),
                listOf(
                    LessonListItem("Тестирование ПО (Пр)", "11:20-12:50", "Преподаватель","212"),
                    LessonListItem("Тестирование ПО (Пр)", "13:15-14:45", "Преподаватель","212"),
                    LessonListItem("Технологии прикладного программирования (Лек)", "15:00-16:30", "Преподаватель","212"),
                    LessonListItem("Технологии прикладного программирования (Пр)", "16:40-18:10","Преподаватель","212"),
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
            resultDaySchedule.add(LessonListItem("Ничего в этот день нету", "", "", ""))
        } else {
            resultDaySchedule.addAll(pair.second)
        }

        return resultDaySchedule
    }

    fun getScheduleForThisDay(): List<ScheduleListItem> {
        val currentDayOfWeek = LocalDate.now().dayOfWeek
        return getDayScheduleFromThisPair(
            weekSchedule.entries.find { it.key.dayOfWeek.ordinal == currentDayOfWeek.ordinal }
                ?.toPair() ?: Pair(
                ScheduleListItem.DayTitleListItem(MyDayOfWeek.SUNDAY), emptyList()
            )
        )
    }
}
