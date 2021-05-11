package com.study.dfinance.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.study.dfinance.R
import com.study.dfinance.model.News

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title : TextView = itemView.findViewById(R.id.news_title)
        val description : TextView = itemView.findViewById(R.id.news_description)
        val image : ImageView = itemView.findViewById(R.id.news_image)


        fun setItem(item : News){
            title.text = item.title
            description.text = item.description
        }
    }
    private val items = ArrayList<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : News = items.get(position)
        holder.setItem(item)
    }

    fun addItem(item : News){
        items.add(item)
    }
}