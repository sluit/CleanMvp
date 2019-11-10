package com.liutoapps.cleanmvp.presentation.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liutoapps.cleanmvp.R
import com.liutoapps.cleanmvp.presentation.ui.photolist.PhotoListActivity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        compositeDisposable.add(Observable.timer(3, TimeUnit.SECONDS).subscribe {
            startActivity(PhotoListActivity.getIntent(this@SplashActivity))
            finish()
        })
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.dispose()
    }
}