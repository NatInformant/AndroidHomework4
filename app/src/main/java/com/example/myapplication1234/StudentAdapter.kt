package com.example.myapplication1234

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1234.databinding.GenderTitleBinding
import com.example.myapplication1234.databinding.StudentListItemBinding

class StudentAdapter(
    private val onStudentClick: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data = mutableListOf<StudentListItem>()

    fun submitValue(list: MutableList<StudentListItem>) {
        data = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType){
            StudentViewType.STUDENT.ordinal -> {
                val binding = StudentListItemBinding.inflate(layoutInflater, parent, false)
                StudentViewHolder(binding, onStudentClick)
            }
            StudentViewType.TITLE.ordinal -> {
                val binding = GenderTitleBinding.inflate(layoutInflater, parent, false)
                GenderTitleViewHolder(binding)
            }
            else ->{
                error("f")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position]){
            is StudentListItem.StudentLastName -> StudentViewType.STUDENT
            else -> StudentViewType.TITLE
        }.ordinal
    }

    override fun getItemCount(): Int =
        data.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is StudentViewHolder -> {
                holder.onBind(data[position] as StudentListItem.StudentLastName, "Студент")
            }
            else ->{

            }
        }
    }

    class StudentViewHolder(
        private val binding: StudentListItemBinding,
        private val onStudentClick: (String) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(name: StudentListItem.StudentLastName, role: String) {
            binding.studentName.text = name.lastName
            binding.studentRole.text = role
            binding.root.setOnClickListener {
                onStudentClick(name.lastName)
            }
        }
    }
    class GenderTitleViewHolder(
        private val binding: GenderTitleBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(gender: StudentListItem.Title) {
            binding.genderTitle.text = gender.title
        }
    }
}

enum class StudentViewType{
    STUDENT, TITLE
}