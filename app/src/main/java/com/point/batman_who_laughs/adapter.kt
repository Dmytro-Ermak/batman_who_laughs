package com.point.batman_who_laughs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter(private val jokesList: List<Joke>) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        val answerTextView: TextView = itemView.findViewById(R.id.answerTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = jokesList[position]

        holder.categoryTextView.text = joke.category
        holder.questionTextView.text = joke.question
        holder.answerTextView.text = truncateAnswer(joke.answer)
    }

    override fun getItemCount(): Int {
        return jokesList.size
    }

    private fun truncateAnswer(answer: String): String {
        return if (answer.length > 45) {
            val substring = answer.substring(0, 45)
            val lastIndex = substring.lastIndexOf(' ')
            answer.take(lastIndex) + "..."
        } else {
            answer
        }
    }
}