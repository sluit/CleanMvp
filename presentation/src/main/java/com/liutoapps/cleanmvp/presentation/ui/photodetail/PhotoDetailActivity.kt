package com.liutoapps.cleanmvp.presentation.ui.photodetail

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.liutoapps.cleanmvp.presentation.model.CommentItem
import com.liutoapps.cleanmvp.presentation.model.PhotoItem
import kotlinx.android.synthetic.main.activity_photo_detail.*
import android.view.MenuItem
import com.liutoapps.cleanmvp.R


class PhotoDetailActivity : AppCompatActivity(), PhotoDetailContract.View {

    companion object {
        private const val EXTRA_PHOTO = "extra_photo"

        fun getIntent(context: Context, photo: PhotoItem): Intent {
            val intent = Intent(context, PhotoDetailActivity::class.java)
            intent.putExtra(EXTRA_PHOTO, photo)
            return intent
        }
    }

    private var photoDetailPresenter: PhotoDetailPresenter? = null
    private val photoDetailCommentAdapter = PhotoDetailCommentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)
        toolbar?.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            it.navigationIcon?.setColorFilter(
                ContextCompat.getColor(this, android.R.color.white),
                PorterDuff.Mode.SRC_ATOP
            )
        }

        setPresenter()
        setRecyclerView()
        setSwipeRefresh()
    }

    private fun setPresenter() {
        photoDetailPresenter = PhotoDetailPresenter()
        photoDetailPresenter?.onAttach(this)

        val photoItem: PhotoItem? = intent.getParcelableExtra(EXTRA_PHOTO)
        photoItem?.let {
            photoDetailPresenter?.setPhotoDetails(photoItem)
        }
    }

    private fun setRecyclerView() {
        photo_detail_comments_recyclerview.layoutManager = LinearLayoutManager(this)
        photo_detail_comments_recyclerview.adapter = photoDetailCommentAdapter
    }

    private fun setSwipeRefresh() {
        photo_detail_comments_swiperefresh.setOnRefreshListener {
            photoDetailPresenter?.refreshComments()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                photoDetailPresenter?.backPressed() ?: false
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    //region presenter callbacks
    override fun showPhotoDetails(photo: PhotoItem) {
        photo_detail_title.text = photo.title
        Glide.with(this).load(photo.url).into(photo_detail_image)
    }

    override fun showComments(commentList: List<CommentItem>) {
        photoDetailCommentAdapter.setItems(commentList)
    }

    override fun closeDetails() {
        onBackPressed()
    }

    override fun stopRefresh() {
        photo_detail_comments_swiperefresh.isRefreshing = false
    }
    //endregion
}
