package com.example.rxjavaexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WaifusAdapter() : RecyclerView.Adapter<WaifusAdapter.WaifusViewHolder>() {

    var waifus = ArrayList<String>()

    class WaifusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var waifuText = itemView.findViewById<TextView>(R.id.waifu_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaifusViewHolder {
        return WaifusViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_line, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WaifusViewHolder, position: Int) {
        var aWaifu = waifus[position]

        holder.waifuText.text = aWaifu
    }

    override fun getItemCount(): Int {
        return waifus.size
    }

    public fun updateList(waifusL: ArrayList<String>){
        waifus = waifusL
        notifyDataSetChanged()
    }
}