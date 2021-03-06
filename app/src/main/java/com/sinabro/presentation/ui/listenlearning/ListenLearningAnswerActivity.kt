package com.sinabro.presentation.ui.listenlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sinabro.R
import com.sinabro.databinding.ActivityListenLearningAnswerBinding
import com.sinabro.presentation.base.BaseActivity
import com.sinabro.shared.util.EditDistance

class ListenLearningAnswerActivity : BaseActivity<ActivityListenLearningAnswerBinding>(R.layout.activity_listen_learning_answer) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        checkEvent()
    }


    //뷰 및 데이터 연결
    private fun initView(){
        val answer = intent.getStringExtra("answer").toString()
        val userAnswer = intent.getStringExtra("userAnswer").toString()
        binding.textListenUserAnswer.text = userAnswer
        binding.textListenAnswer.text = answer
        val score = EditDistance().runAlgorithm(answer, userAnswer)
        binding.textListenScore.text = score.toString()
    }

    //클릭 이벤트
    private fun checkEvent(){
        binding.textListenLearningMain.setOnClickListener {
            finish()
        }
        binding.textListenLearningNext.setOnClickListener {
            val intent = Intent(this, ListenLearningActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}