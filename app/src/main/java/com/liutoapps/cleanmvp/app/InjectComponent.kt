package com.liutoapps.cleanmvp.app

import com.liutoapps.cleanmvp.presentation.injector.AppComponent
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = [])
interface InjectComponent : AppComponent
