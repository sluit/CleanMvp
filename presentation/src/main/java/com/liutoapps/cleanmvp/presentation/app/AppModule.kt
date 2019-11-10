package com.liutoapps.cleanmvp.presentation.app

import android.content.Context
import com.liutoapps.cleanmvp.presentation.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: App) {

    @Provides
    @Singleton
    fun provideApp(): App = application

    @Provides
    @Singleton
    fun provideContext(): Context = application

}