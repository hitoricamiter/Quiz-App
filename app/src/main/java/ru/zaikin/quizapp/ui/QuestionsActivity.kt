package ru.zaikin.quizapp.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ru.zaikin.quizapp.R
import ru.zaikin.quizapp.model.Question
import ru.zaikin.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView
    private lateinit var checkButton: Button

    private var currentPosition = 1
    private val questionsList = Constants.getQuestions()
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progressbar)
        textViewProgress = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        flagImage = findViewById(R.id.image_flag)
        checkButton = findViewById(R.id.button_send)
        textViewOptionOne = findViewById(R.id.text_view_option_one)
        textViewOptionTwo = findViewById(R.id.text_view_option_two)
        textViewOptionThree = findViewById(R.id.text_view_option_three)
        textViewOptionFour = findViewById(R.id.text_view_option_four)

        progressBar.max = questionsList.size

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        showNextQuestion()
    }

    private fun showNextQuestion() {
        resetOptions()
        selectedAnswer = 0
        answered = false

        if (currentPosition <= questionsList.size) {
            currentQuestion = questionsList[currentPosition - 1]

            flagImage.setImageResource(currentQuestion.image)
            textViewQuestion.text = currentQuestion.question
            textViewOptionOne.text = currentQuestion.optionOne
            textViewOptionTwo.text = currentQuestion.optionTwo
            textViewOptionThree.text = currentQuestion.optionThree
            textViewOptionFour.text = currentQuestion.optionFour

            progressBar.progress = currentPosition
            textViewProgress.text = "$currentPosition/${progressBar.max}"

            checkButton.text = if (currentPosition == questionsList.size) "FINISH" else "Check"
        }
    }

    private fun resetOptions() {
        val options = listOf(textViewOptionOne, textViewOptionTwo, textViewOptionThree, textViewOptionFour)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.text_view_option_one -> selectedOptionText(textViewOptionOne, 1)
            R.id.text_view_option_two -> selectedOptionText(textViewOptionTwo, 2)
            R.id.text_view_option_three -> selectedOptionText(textViewOptionThree, 3)
            R.id.text_view_option_four -> selectedOptionText(textViewOptionFour, 4)
            R.id.button_send -> {
                if (!answered) {
                    if (selectedAnswer != 0) {
                        checkAnswer()
                    }
                } else {
                    currentPosition++
                    showNextQuestion()
                }
            }
        }
    }

    private fun selectedOptionText(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()
        selectedAnswer = selectedOptionNumber
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun checkAnswer() {
        answered = true

        val correctOption = currentQuestion.correctAnswer

        if (selectedAnswer == correctOption) {
            when(correctOption) {
                1 -> textViewOptionOne.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                2 -> textViewOptionTwo.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                3 -> textViewOptionThree.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                4 -> textViewOptionFour.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
        } else {
            when(selectedAnswer) {
                1 -> textViewOptionOne.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                2 -> textViewOptionTwo.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                3 -> textViewOptionThree.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                4 -> textViewOptionFour.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
        }

        checkButton.text = if (currentPosition == questionsList.size) "FINISH" else "NEXT"
    }
}
