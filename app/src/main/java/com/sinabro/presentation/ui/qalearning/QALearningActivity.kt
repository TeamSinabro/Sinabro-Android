package com.sinabro.presentation.ui.qalearning

import android.os.Bundle
import androidx.activity.viewModels
import com.sinabro.R
import com.sinabro.databinding.ActivityQalearningBinding
import com.sinabro.presentation.base.BaseActivity
import com.sinabro.presentation.ui.qalearning.viewmodel.QALearningViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QALearningActivity : BaseActivity<ActivityQalearningBinding>(R.layout.activity_qalearning) {
    private val qaLearningViewModel : QALearningViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setData()
        initQAData()
        checkLoading()
        goMain()
    }

    //데이터 받아오기
    private fun setData(){
        binding.textQaLearningSearch.setOnClickListener {
            showLoading()
            val question = binding.etQaSentence.text.toString()
            qaLearningViewModel.getQALearningData(question)
        }
    }

    //데이터 넣기
    private fun initQAData(){
        qaLearningViewModel.answer.observe(this){
            binding.qaData = it
        }
    }

    //로딩 체크
    private fun checkLoading(){
        qaLearningViewModel.onLoadingEnd.observe(this){
            dismissLoading()
        }
    }

    //메인 이동
    private fun goMain(){
        binding.textQaLearningMain.setOnClickListener {
            finish()
        }
    }

}