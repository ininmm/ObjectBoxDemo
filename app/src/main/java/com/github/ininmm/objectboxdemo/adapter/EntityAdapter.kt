package com.github.ininmm.objectboxdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.ininmm.objectboxdemo.R
import com.github.ininmm.objectboxdemo.model.ExampleEntity
import kotlinx.android.synthetic.main.item_entity.view.*

/**
 * Created by User
 * on 2018/3/4.
 */
class EntityAdapter : RecyclerView.Adapter<EntityAdapter.ViewHolder>() {
    private var dataset: List<ExampleEntity> = ArrayList()
    var itemClick: ((Int, String) -> Unit)? = null

    fun setNotes(notes: List<ExampleEntity>) {
        dataset = notes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_entity, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder.apply {
            this!!.itemView.tag = position
            itemView.setOnClickListener {
                dataset[position].text?.let { itemClick?.invoke(position, it) }
            }
            text.text = dataset[position].text
            comment.text = dataset[position].comment
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text: TextView = view.textViewNoteText
        var comment: TextView = view.textViewNoteComment
    }
}