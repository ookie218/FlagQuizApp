package com.ookie.quizapp

import java.util.*
import kotlin.collections.ArrayList

object Constants {
    //Create a constant variables which we required in the result screen
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions() : ArrayList<Question> {
        val questionList = ArrayList<Question>()

        //Define the questions
        val question1 = Question(1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, "Argentina", "Australia", "India", "Austria", 1)

        //Update the Quiz List
        questionList.add(question1)

        val question2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        questionList.add(question2)

        // 3
        val question3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionList.add(question3)

        // 4
        val question4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionList.add(question4)

        // 5
        val question5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionList.add(question5)

        // 6
        val question6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionList.add(question6)

        // 7
        val question7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionList.add(question7)

        // 8
        val question8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionList.add(question8)

        // 9
        val question9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionList.add(question9)

        // 10
        val question10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionList.add(question10)

        // 11
        val question11 = Question(
            11, "What country does this flag belong to?",
            R.drawable.ic_flag_of_china,
            "Nepal", "North Korea",
            "Pakistan", "China", 4
        )

        questionList.add(question11)

        // 12
        val question12 = Question(
            12, "What country does this flag belong to?",
            R.drawable.ic_flag_of_canada,
            "Canada", "United States",
            "Morocco", "Nepal", 1
        )

        questionList.add(question12)

        // 13
        val question13 = Question(
            13, "What country does this flag belong to?",
            R.drawable.ic_flag_of_europe,
            "Haiti", "Europe",
            "Madagascar", "Liberia", 2
        )

        questionList.add(question13)

        // 14
        val question14 = Question(
            14, "What country does this flag belong to?",
            R.drawable.ic_flag_of_france,
            "Hungary", "Iran",
            "France", "Lebanon", 3
        )

        questionList.add(question14)

        // 15
        val question15 = Question(
            15, "What country does this flag belong to?",
            R.drawable.ic_flag_of_ghana,
            "Ghana", "Finland",
            "Croatia", "Denmark", 1
        )

        questionList.add(question15)

        // 16
        val question16 = Question(
            16, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kenya,
            "Costa Rico", "Ethiopia",
            "Egypt", "Kenya", 4
        )

        questionList.add(question16)

        // 17
        val question17 = Question(
            17, "What country does this flag belong to?",
            R.drawable.ic_flag_of_japan,
            "Japan", "Belize",
            "Columbia", "Palestine", 1
        )

        questionList.add(question17)

        // 18
        val question18 = Question(
            18, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Fiji",
            "Bahamas", "Kenya", 1
        )

        questionList.add(question18)

        // 19
        val question19 = Question(
            19, "What country does this flag belong to?",
            R.drawable.ic_flag_of_phillipines,
            "Algeria", "Phillipines",
            "Sudan", "Armenia", 2
        )

        questionList.add(question19)

        // 20

        val question20 = Question(
            20, "*Bonus* What countries would fall under this flag",
            R.drawable.ic_flag_of_mexico,
            "Afghanistan", "Mexico",
            "Albania", "Kenya", 2
        )

        questionList.add(question20)





        //Shuffle Collection
        questionList.shuffle()
        return questionList
    }

}