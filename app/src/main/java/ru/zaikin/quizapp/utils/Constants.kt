package ru.zaikin.quizapp.utils

import ru.zaikin.quizapp.R
import ru.zaikin.quizapp.model.Question

object Constants {
    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()

        val quest1 = Question(
            1, "What country does this flag belon'?",
            R.drawable.cyflag, "Italy", "India", "Cyprus",
            "Linethuala", 3
        )

        val quest2 = Question(
            2, "What country does this flag belon'?",
            R.drawable.fiflag, "Italy", "Finland", "Cyprus",
            "Linethuala", 2
        )

        val quest3 = Question(
            3, "What country does this flag belon'?",
            R.drawable.gmflag, "Italy", "India", "Cyprus",
            "Germany", 4
        )

        val quest4 = Question(
            4, "What country does this flag belon'?",
            R.drawable.grflag, "Greece", "India", "Cyprus",
            "Linethuala", 1
        )

        val quest5 = Question(
            5, "What country does this flag belon'?",
            R.drawable.ksflag, "Italy", "India", "Korea",
            "Linethuala", 3
        )

        val quest6 = Question(
            6, "What country does this flag belon'?",
            R.drawable.plflag, "Italy", "Poland", "Cyprus",
            "Linethuala", 2
        )

        val quest7 = Question(
            7, "What country does this flag belon'?",
            R.drawable.rsflag, "Russia", "India", "Cyprus",
            "Linethuala", 1
        )

        val quest8 = Question(
            8, "What country does this flag belon'?",
            R.drawable.tuflag, "Italy", "India", "Cyprus",
            "Turkey", 4
        )

        val quest9 = Question(
            9, "What country does this flag belon'?",
            R.drawable.ukflag, "Italy", "England", "Cyprus",
            "Turkey", 2
        )

        val quest10 = Question(
            10, "What country does this flag belon'?",
            R.drawable.usflag, "America", "India", "Cyprus",
            "Turkey", 1
        )


        questions.add(quest1)
        questions.add(quest2)
        questions.add(quest3)
        questions.add(quest4)
        questions.add(quest5)
        questions.add(quest6)
        questions.add(quest7)
        questions.add(quest8)
        questions.add(quest9)
        questions.add(quest10)

        return questions
    }
}