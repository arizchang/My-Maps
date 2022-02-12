package com.arizchang.mymaps

import android.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arizchang.mymaps.models.UserMap

private const val TAG = "MapsAdapter"
class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onItemClick(position: Int)
        fun onItemLongClick(position: Int)
    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(com.arizchang.mymaps.R.layout.item_user_map, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "in onBindViewHolder")
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener {
            Log.i(TAG, "Tapped on position $position")
            onClickListener.onItemClick(position)
        }

        holder.itemView.setOnLongClickListener{
            onClickListener.onItemLongClick(position)
            true
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(com.arizchang.mymaps.R.id.tvMapTitle)
        textViewTitle.text = userMap.title
    }

    // Returns total count of items in the list
    override fun getItemCount(): Int {
        return userMaps.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
