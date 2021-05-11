package com.study.dfinance.widget

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.study.dfinance.R
import com.study.dfinance.model.News

open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name : TextView = itemView.findViewById(R.id.news_title)
    val description : TextView = itemView.findViewById(R.id.news_description)
    val image : ImageView = itemView.findViewById(R.id.news_image)


    fun setItem(item : News){
        name.text = item.title
        description.text = item.description
    }
}