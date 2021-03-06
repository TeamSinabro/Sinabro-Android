package com.sinabro.presentation.ui.qalearning.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sinabro.domain.usecase.qalearning.GetQALearningDataUseCase
import com.sinabro.presentation.base.LoadedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QALearningViewModel @Inject constructor(
    private val getQALearningDataUseCase : GetQALearningDataUseCase
) : ViewModel(), LoadedViewModel {

    var answer = MutableLiveData<String>()



    //QA데이터 받기
    fun getQALearningData(question : String){
        viewModelScope.launch {
            runCatching { getQALearningDataUseCase(question) }
                .onSuccess {
                    answer.value = it.answer
                    Timber.d("qa 서버 통신 완료")
                }
                .onFailure {
                    it.printStackTrace()
                    Timber.d("qa 서버 통신 실패")
                }
                .also {
                    onLoadingEnd.value = true
                }
        }
    }

    override val onLoadingEnd = MutableLiveData<Boolean>()
}