package com.liutoapps.cleanmvp.app

import com.liutoapps.cleanmvp.presentation.App
import com.liutoapps.cleanmvp.presentation.app.AppModule
import com.liutoapps.cleanmvp.presentation.injector.AppComponent
import com.liutoapps.cleanmvp.presentation.injector.Injector

class InjectApp : App() {

    override fun onCreate() {
        super.onCreate()

        Injector.initAppComponent(getDaggerComponent())
    }

    private fun getDaggerComponent(): AppComponent {
        return DaggerInjectComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}