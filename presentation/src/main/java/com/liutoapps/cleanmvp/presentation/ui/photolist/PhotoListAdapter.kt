package com.liutoapps.cleanmvp.presentation.ui.photolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liutoapps.cleanmvp.R
import com.liutoapps.cleanmvp.presentation.model.PhotoItem

class PhotoListAdapter(private val photoClickListener: PhotoListItemView.OnPhotoClickListener) :
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    private var items: List<PhotoItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PhotoItem) =
            (itemView as PhotoListItemView).setData(item, photoClickListener)
    }

    fun setItems(list: List<PhotoItem>) {
        this.items = list
        notifyDataSetChanged()
    }

}