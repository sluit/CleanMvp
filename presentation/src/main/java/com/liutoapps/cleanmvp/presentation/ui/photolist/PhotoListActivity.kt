package com.liutoapps.cleanmvp.presentation.ui.photolist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.liutoapps.cleanmvp.R
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import com.liutoapps.cleanmvp.presentation.ui.photodetail.PhotoDetailActivity
import kotlinx.android.synthetic.main.activity_photo_list.*

class PhotoListActivity : AppCompatActivity(), PhotoListContract.View, PhotoListItemView.OnPhotoClickListener {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PhotoListActivity::class.java)
        }
    }

    private var photoListPresenter: PhotoListPresenter? = null
    private val photoListAdapter = PhotoListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_list)
        toolbar?.let {
            setSupportActionBar(it)
        }

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

    override fun onPhotoItemClicked(photoItem: PhotoItem) {
        photoListPresenter?.clickedPhotoItem(photoItem)
    }

    //region presenter callbacks
    override fun setLoading(loading: Boolean) {
        photo_list_loading.visibility = if (loading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun showList(photoList: List<PhotoItem>) {
        photo_list_recyclerview.visibility = View.VISIBLE
        photoListAdapter.setItems(photoList)
    }

    override fun navigateToDetails(photoItem: PhotoItem) {
        startActivity(PhotoDetailActivity.getIntent(this, photoItem))
    }
    //endregion

    override fun onDestroy() {
        photoListPresenter?.onDetatch()
        super.onDestroy()
    }
}
