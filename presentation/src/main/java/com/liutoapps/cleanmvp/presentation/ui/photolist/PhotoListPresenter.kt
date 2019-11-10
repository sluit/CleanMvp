package com.liutoapps.cleanmvp.presentation.ui.photolist

import android.util.Log
import com.liutoapps.cleanmvp.domain.usecase.GetPhotosUseCase
import com.liutoapps.cleanmvp.presentation.injector.AppComponent
import com.liutoapps.cleanmvp.presentation.injector.Injector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import dagger.android.AndroidInjection;

class PhotoListPresenter : PhotoListContract.Presenter {

    @Inject
    lateinit var getPhotosUseCase: GetPhotosUseCase
    private var view: PhotoListContract.View? = null

    private val compositeDisposable = CompositeDisposable()

    override fun onAttach(view: PhotoListContract.View) {
        Injector.appComponent.inject(this)
        this.view = view
        compositeDisposable.add(
            getPhotosUseCase.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response -> Log.d("TAG", "size: " + response.size) },
                    { t: Throwable? ->
                        Log.e("TAG", "error", t)
                    })
        )
    }

    override fun onDetatch() {
        compositeDisposable.dispose()
    }

}