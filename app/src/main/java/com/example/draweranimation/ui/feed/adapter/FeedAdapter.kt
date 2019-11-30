package com.example.draweranimation.ui.feed.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.draweranimation.R
import com.example.draweranimation.data.Response

class FeedAdapter(val feedList : List<Response>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val motionLayout = view.findViewById<MotionLayout>(R.id.item_layout)
        val author = view.findViewById<TextView>(R.id.author)
        val quoteDesc = view.findViewById<TextView>(R.id.quote_desc)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_item, parent, false)
        return FeedViewHolder(view = view)
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val data = feedList[position]

        holder.author.text = data.author
        holder.quoteDesc.text = data.en
        holder.motionLayout.transitionToState(R.id.end)
    }
}