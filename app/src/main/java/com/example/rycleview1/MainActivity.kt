    package com.example.rycleview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rycleview1.adapter.TodoAdapter
import com.example.rycleview1.databinding.ActivityMainBinding
import com.example.rycleview1.model.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var todoList = mutableListOf(
            Todo("Opening", true),
            Todo("Penjelasan", false),
            Todo("Recycler View", false),
            Todo("Read the Rules", false),
            Todo("Praktek", false),
            Todo("Plugin", false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodoList.adapter = adapter
        binding.rvTodoList.layoutManager = LinearLayoutManager(this)


        binding.button.setOnClickListener {
            val title =  binding.etAddList.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}