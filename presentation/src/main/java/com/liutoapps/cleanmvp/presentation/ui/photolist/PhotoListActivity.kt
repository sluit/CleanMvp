package com.liutoapps.cleanmvp.presentation.ui.photolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.liutoapps.cleanmvp.R
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import kotlinx.android.synthetic.main.activity_photo_list.*

class PhotoListActivity : AppCompatActivity(), PhotoListContract.View {

    private var photoListPresenter: PhotoListPresenter? = null
    private val photoListAdapter = PhotoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)

        setPresenter()
        setRecyclerView()
    }

    private fun setPresenter() {
        photoListPresenter = PhotoListPresenter()
        photoListPresenter?.onAttach(this)
    }

    private fun setRecyclerView() {
        photo_list_recyclerview.layoutManager = LinearLayoutManager(this)
        photo_list_recyclerview.adapter = photoListAdapter
    }

    override fun showList(photoList: ArrayList<PhotoItem>) {
        photoListAdapter.setItems(photoList)
    }
}
