package com.sinabro.data.datasource.remote.pronounce

import com.sinabro.data.api.pronounce.PronounceSentenceService
import com.sinabro.data.model.request.RequestPronounceData
import com.sinabro.data.model.response.ResponsePronounceData
import com.sinabro.data.model.response.ResponsePronounceSentenceData
import javax.inject.Inject

class PronounceSentenceDataImpl @Inject  constructor(
    private val service : PronounceSentenceService
) : PronounceSentenceDataSource {
    override suspend fun getPronunciationSentence(
        publisher: String,
        subject: String,
        chapter: Int
    ): ResponsePronounceSentenceData {
        return service.getPronunciationSentence(publisher, subject, chapter)
    }
}