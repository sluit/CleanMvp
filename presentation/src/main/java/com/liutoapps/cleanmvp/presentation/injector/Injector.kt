package com.liutoapps.cleanmvp.presentation.injector

object Injector {

    lateinit var appComponent: AppComponent private set

    fun initAppComponent(app: AppComponent) {
        appComponent = app
    }

}