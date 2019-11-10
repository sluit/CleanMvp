package com.liutoapps.cleanmvp.presentation.ui.photolist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liutoapps.cleanmvp.presentation.model.PhotoItem

class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    private var items: List<PhotoItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PhotoItem) = (itemView as PhotoListItemView).setData(item)
    }

    fun setItems(list: List<PhotoItem>) {
        this.items = list
        notifyDataSetChanged()
    }

}