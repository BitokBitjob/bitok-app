package com.example.bitjobapk.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bitjobapk.R
import com.example.bitjobapk.data.Event

class MyAdapter () :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
        parent,false)
        return  MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = events[position]
//        holder.titleImage. = currentItem.image
        holder.time.text = currentItem.time
        holder.title.text = currentItem.title
        holder.name.text = currentItem.name
        holder.description.text = currentItem.description

    }

    override fun getItemCount(): Int {
        return events.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val titleImage : ImageView = itemView.findViewById(R.id.clockimageView)
        val time : TextView = itemView.findViewById(R.id.listtextview1)
        val title : TextView = itemView.findViewById(R.id.listtextview2)
        val name : TextView = itemView.findViewById(R.id.listtextview3)
        val description : TextView = itemView.findViewById(R.id.listtextview4)

    }

    private val diffCallback = object : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var events: List<Event>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

}