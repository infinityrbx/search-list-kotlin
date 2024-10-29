package com.example.search_list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.search_list.model.Student

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var searchView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        val studentList = listOf(
            Student("Nguyen Van A", "20123456"),
            Student("Tran Thi B", "20123457"),
            Student("Le Van C", "20123458"),
            Student("Pham Thi D", "20123459"),
            Student("Hoang Van E", "20123460"),
            Student("Nguyen Thi F", "20123461"),
            Student("Bui Van G", "20123462"),
            Student("Phan Thi H", "20123463"),
            Student("Do Van I", "20123464"),
            Student("Vu Thi J", "20123465"),
            Student("Ngo Van K", "20123466"),
            Student("Pham Thi L", "20123467"),
            Student("Ly Van M", "20123468"),
            Student("Huynh Thi N", "20123469"),
            Student("Dinh Van O", "20123470"),
            Student("Trinh Thi P", "20123471"),
            Student("Tran Van Q", "20123472"),
            Student("Le Thi R", "20123473"),
            Student("Hoang Van S", "20123474"),
            Student("Nguyen Thi T", "20123475"),
            Student("Pham Van U", "20123476"),
            Student("Tran Thi V", "20123477"),
            Student("Ngo Van W", "20123478"),
            Student("Pham Thi X", "20123479"),
            Student("Tran Van Y", "20123480"),
            Student("Le Thi Z", "20123481"),
            Student("Doan Van AA", "20123482"),
            Student("Phan Thi BB", "20123483"),
            Student("Nguyen Van CC", "20123484"),
            Student("Pham Thi DD", "20123485")
        )

        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                if (query.length > 2) {
                    val filteredList = studentList.filter {
                        it.name.contains(query, ignoreCase = true) || it.mssv.contains(query)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    studentAdapter.updateList(studentList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}