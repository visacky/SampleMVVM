package com.example.samplemvvm.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.samplemvvm.R
import com.example.samplemvvm.data.api.apiresponse.ArticleResdetail
import com.example.samplemvvm.view.ArticleDetailActivity
import kotlinx.android.synthetic.main.item_adapter_layout.view.*

class ItemAdapter(val items: List<ArticleResdetail>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_adapter_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = items[position].title
        holder.date?.text = items[position].lastUpdate
        holder.shortDescription?.text = items[position].description

        holder.cardView.setOnClickListener {
            val intent = Intent(context, ArticleDetailActivity::class.java)
            intent.putExtra("detailName", items[position].detailName)
            context.startActivity(intent)
        }

        Glide.with(context)
            .load(items[position].image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.itemImage)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val title = view.title
    val date = view.date
    val shortDescription = view.short_description
    val itemImage = view.item_image
    val cardView = view.card_view
}