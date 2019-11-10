package com.liutoapps.cleanmvp.presentation.injector

import com.liutoapps.cleanmvp.presentation.ui.photolist.PhotoListPresenter
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent
interface AppComponent {

    fun inject(presenter: PhotoListPresenter)

}