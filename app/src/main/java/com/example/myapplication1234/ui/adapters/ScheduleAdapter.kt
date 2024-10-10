package com.example.myapplication1234.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1234.databinding.DayTitleElementBinding
import com.example.myapplication1234.databinding.LessonElementBinding
import com.example.myapplication1234.models.LessonListItem
import com.example.myapplication1234.models.ScheduleListItem
import com.example.myapplication1234.models.ScheduleViewType

class ScheduleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data = listOf<ScheduleListItem>()

    fun submitValue(list: List<ScheduleListItem>) {
        data = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ScheduleViewType.Lesson.ordinal -> {
                val binding = LessonElementBinding.inflate(layoutInflater, parent, false)
                LessonElementViewHolder(binding)
            }

            ScheduleViewType.DayTitle.ordinal -> {
                val binding = DayTitleElementBinding.inflate(layoutInflater, parent, false)
                DayTitleElementViewHolder(parent.context, binding)
            }

            else -> {
                error("There is now such type for list element")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is ScheduleListItem.DayTitleListItem -> ScheduleViewType.DayTitle
            is LessonListItem -> ScheduleViewType.Lesson
            else -> error("There is now such type for list element")
        }.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LessonElementViewHolder -> {
                holder.onBind(data[position] as LessonListItem)
            }

            is DayTitleElementViewHolder -> {
                holder.onBind(data[position] as ScheduleListItem.DayTitleListItem)
            }
        }
    }

    class LessonElementViewHolder(
        private val binding: LessonElementBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(lessonItem: LessonListItem) {
            binding.lessonName.text = lessonItem.lessonName

            if (lessonItem.lessonTime == "") {
                binding.lessonTime.visibility = View.GONE
            } else {
                binding.lessonTime.text = lessonItem.lessonTime
                binding.lessonTeacher.text = lessonItem.lessonTeacher
                binding.lessonAuditorium.text = lessonItem.lessonAuditorium
            }
        }
    }

    class DayTitleElementViewHolder(
        private val context: Context,
        private val binding: DayTitleElementBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(dayTitleItem: ScheduleListItem.DayTitleListItem) {
            binding.dayTitle.text = context.getText(dayTitleItem.dayOfWeek.dayOfWeekNameId)
        }
    }
}
