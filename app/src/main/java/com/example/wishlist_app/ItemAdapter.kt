package com.example.wishlist_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: MutableList<Items>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemNameTextView: TextView
        val itemCostView: TextView
        val urlView: TextView


        init{
            itemNameTextView = itemView.findViewById(R.id.item_name)
            itemCostView = itemView.findViewById(R.id.item_cost)
            urlView = itemView.findViewById(R.id.url_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on positions
        val item = items.get(position)
        // Set item views based on views and data model
        holder.itemNameTextView.text = item.name
        holder.urlView.text = item.url
        holder.itemCostView.text = item.cost.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}