package com.sinabro.data.datasource.remote.pronounce

import com.sinabro.data.model.request.RequestPronounceData
import com.sinabro.data.model.response.pronounce.ResponsePronounceData

interface PronounceDataSource {

    suspend fun postPronounce(requestPronounceData: RequestPronounceData) : ResponsePronounceData
}