package ru.zaikin.quizapp.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.zaikin.quizapp.R
import ru.zaikin.quizapp.utils.Constants
import kotlin.math.sign

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        val questionsList = Constants.getQuestions()
        Log.d("QuestionsSize", "$questionsList.size")
    }
}