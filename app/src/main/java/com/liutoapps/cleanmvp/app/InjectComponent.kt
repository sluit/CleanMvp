package com.liutoapps.cleanmvp.app

import com.liutoapps.cleanmvp.data.remote.NetworkModule
import com.liutoapps.cleanmvp.data.repository.RepositoryModule
import com.liutoapps.cleanmvp.presentation.app.AppModule
import com.liutoapps.cleanmvp.presentation.injector.AppComponent
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
interface InjectComponent : AppComponent
