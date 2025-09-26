package ru.zaikin.quizapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.zaikin.quizapp.R
import ru.zaikin.quizapp.model.Question
import ru.zaikin.quizapp.utils.Constants
import kotlin.math.sign

class QuestionsActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

    private val currentPosition = 1
    val questionsList = Constants.getQuestions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressbar)
        textViewProgress = findViewById<TextView>(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        flagImage = findViewById<ImageView>(R.id.image_flag)

        textViewOptionOne = findViewById<TextView>(R.id.text_view_option_one)
        textViewOptionTwo = findViewById<TextView>(R.id.text_view_option_two)
        textViewOptionThree = findViewById<TextView>(R.id.text_view_option_three)
        textViewOptionFour = findViewById<TextView>(R.id.text_view_option_four)


        Log.d("QuestionsSize", "$questionsList.size")
        setQuestion()
    }

    private fun setQuestion() {
        val question = questionsList[currentPosition - 1]
        flagImage.setImageResource(question.image)
        progressBar.progress = currentPosition
        textViewProgress.text = "$currentPosition/${progressBar.max}"
        textViewQuestion.text = question.question
        textViewOptionOne.text = question.optionOne
        textViewOptionTwo.text = question.optionTwo
        textViewOptionThree.text = question.optionThree
        textViewOptionFour.text = question.optionFour
    }
}