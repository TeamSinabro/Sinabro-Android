package com.sinabro.domain.usecase

import com.sinabro.domain.model.request.PronouncePostItem
import com.sinabro.domain.model.response.PronouncePostData
import com.sinabro.domain.repository.pronounce.PronounceRepository
import javax.inject.Inject


class PostPronounceDataUseCase @Inject constructor(
    private val repository : PronounceRepository
) {

    suspend operator fun invoke(pronouncePostItem: PronouncePostItem) : PronouncePostData{
        return repository.postPronounce(pronouncePostItem)
    }
}