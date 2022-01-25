package com.madscientist.memeviewerx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// A recycler view needs an adapter which can provide the data that needs to be shown in the view
// The adapter should have a viewholder that holds the view that is to be shown in the recycler view

class MemeAdapter(val memeList: List<Meme>): RecyclerView.Adapter<MemeAdapter.MemeViewHolder>() {
    // The viewholder holds the contents of the layout
    class MemeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val memeName = itemView.findViewById<TextView>(R.id.memeText)
        val memeImage = itemView.findViewById<ImageView>(R.id.memeImage)

    }

    // This creates the view holder and converts the xml layout to java
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_meme, parent, false)
        return MemeViewHolder(view)
    }

    // This binds actual data to the layout
    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.memeName.text = memeList[position].memeName
        holder.memeImage.setImageBitmap(memeList[position].memeImage)
    }

    override fun getItemCount(): Int {
        return memeList.size
    }
}