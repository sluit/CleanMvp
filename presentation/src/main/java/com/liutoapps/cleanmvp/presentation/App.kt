package com.liutoapps.cleanmvp.presentation

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.liutoapps.cleanmvp.BuildConfig
import timber.log.Timber


open class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.ERROR || priority == Log.WARN) {
                //send to remote server
            }
        }


    }
}