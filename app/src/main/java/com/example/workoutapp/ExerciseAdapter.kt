package com.example.workoutapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_active.view.*

class ExerciseAdapter(val items: ArrayList<ExerciseModel>, val context: Context) :
    RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {


    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
       val tvUser = view.tvTimer
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_design_recycler_view, parent ,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExerciseModel = items[position]
        holder.tvUser.text = model.getId().toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}