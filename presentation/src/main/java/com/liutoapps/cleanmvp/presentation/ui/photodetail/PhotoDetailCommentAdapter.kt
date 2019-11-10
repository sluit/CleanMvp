package com.liutoapps.cleanmvp.presentation.ui.photodetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liutoapps.cleanmvp.R
import com.liutoapps.cleanmvp.presentation.model.CommentItem

class PhotoDetailCommentAdapter : RecyclerView.Adapter<PhotoDetailCommentAdapter.ViewHolder>() {

    private var items: List<CommentItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_comment, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: CommentItem) = (itemView as PhotoDetailCommentItemView).setData(item)
    }

    fun setItems(list: List<CommentItem>) {
        this.items = list
        notifyDataSetChanged()
    }

}