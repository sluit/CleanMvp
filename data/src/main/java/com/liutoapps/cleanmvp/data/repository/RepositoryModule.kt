package com.liutoapps.cleanmvp.data.repository

import com.liutoapps.cleanmvp.domain.repository.PhotoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindPhotosRepository(repository: PhotoRepositoryImpl): PhotoRepository


}

