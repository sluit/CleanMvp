package com.liutoapps.cleanmvp.domain.usecase

import com.liutoapps.cleanmvp.domain.model.Photo
import com.liutoapps.cleanmvp.domain.repository.PhotoRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val photoRepository: PhotoRepository
) {
    fun get(): Single<List<Photo>> = photoRepository.getPhotos()
}