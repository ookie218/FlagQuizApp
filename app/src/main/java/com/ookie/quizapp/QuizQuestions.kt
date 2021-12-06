package com.ookie.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.collections.ArrayList


//Also extending View, OnClickListener (we're gonna give the text views this functionality)
class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null

    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null

    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var buttonSubmit: Button? = null

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null


    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    private var mSelectedOptionPosition: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgressBar = findViewById(R.id.tv_progress)

        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)

        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)

        buttonSubmit = findViewById(R.id.submitButton)


        mQuestionList = Constants.getQuestions()

        setQuestions()

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)

    }

    private fun setQuestions(){

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size) {
            buttonSubmit?.text = "FINISH"
        } else {
            buttonSubmit?.text = "SUBMIT"
        }

        //Is progress bar running? If not, set position
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition" + "/" + progressBar?.getMax()

        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)

        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour

    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawable
                )
            }

            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawable
                )
            }

            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawable
                )
            }

            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(
                    this@QuizQuestions,
                    drawable
                )
            }
        }
    }


    override fun onClick(view: View?) {
        //Toast.makeText(this@QuizQuestions, "You have successfully clicked a button", Toast.LENGTH_LONG).show()

        when (view?.id) {
            R.id.tv_option1 -> {
                tvOption1?.let {
                    selectedOptionsView(it, 1)
                }
            }

            R.id.tv_option2 -> {
                tvOption2?.let {
                    selectedOptionsView(it, 2)
                }
            }
            R.id.tv_option3 -> {
                tvOption3?.let {
                    selectedOptionsView(it, 3)
                }
            }

            R.id.tv_option4 -> {
                tvOption4?.let {
                    selectedOptionsView(it, 4)
                }
            }

            R.id.submitButton -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        //mCurrentPosition <= 20 (maybe show under 20)
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestions()
                        }
                        else -> {
                            Toast.makeText(
                                this@QuizQuestions,
                                "You have successfully completed the quiz",
                                Toast.LENGTH_LONG
                            ).show()

                            val intent = Intent(this@QuizQuestions, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        buttonSubmit?.text = "FINISH"
                    } else {
                        buttonSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

     private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        tvOption1?.let {
            options.add(0, it)
        }

        tvOption2?.let {
            options.add(1, it)
        }

        tvOption3?.let {
            options.add(2, it)
        }

        tvOption4?.let {
            options.add(3, it)
        }

         for (option in options) {
             option.setTextColor(Color.parseColor("#7A8089"))
             option.typeface = Typeface.DEFAULT
             option.background = ContextCompat.getDrawable(
                 this@QuizQuestions,
                 R.drawable.default_option_border_bg
             )
         }
    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        //Set Style / Color on Selected Option
        tv.setTextColor(Color.BLUE)

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestions,
            R.drawable.selector_option_border_bg
        )
    }

}