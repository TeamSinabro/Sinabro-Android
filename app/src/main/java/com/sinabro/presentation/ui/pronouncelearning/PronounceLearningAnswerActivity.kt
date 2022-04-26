package com.sinabro.presentation.ui.pronouncelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sinabro.R
import com.sinabro.databinding.ActivityPronounceLearningAnswerBinding
import com.sinabro.databinding.ActivityPronounceLearningBinding
import com.sinabro.presentation.base.BaseActivity

class PronounceLearningAnswerActivity : BaseActivity<ActivityPronounceLearningAnswerBinding>(R.layout.activity_pronounce_learning_answer) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goMain()
    }

    //메인으로 이동
    private fun goMain(){
        binding.textPronounceLearningMain.setOnClickListener {
            finish()
        }
    }

    //다음문제
}