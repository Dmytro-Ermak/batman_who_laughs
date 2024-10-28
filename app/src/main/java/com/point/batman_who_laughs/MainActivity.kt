package com.point.batman_who_laughs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.jokesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = JokeAdapter(jokesList)
        recyclerView.adapter = adapter
    }
}