package com.supranet.trivia

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import androidx.core.content.ContextCompat
import com.tapadoo.alerter.Alerter

class QuizQuestionsActivity : AppCompatActivity() {
    private var totalScore = 0
    private var questionsList: ArrayList<Question> = ArrayList()
    private var currentQuestionIndex = 0
    private var selectedAlternativeIndex = -1

    private var tvQuestion: TextView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var btnNext: Button? = null
    private var tvAlternatives: ArrayList<TextView>? = null
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tvQuestion = findViewById(R.id.tvQuestion)
        btnNext = findViewById(R.id.btnSubmit)
        tvAlternatives = arrayListOf(
            findViewById(R.id.optionOne),
            findViewById(R.id.optionTwo),
            findViewById(R.id.optionThree),
            findViewById(R.id.optionFour),
        )
        webView = findViewById(R.id.webview)
        val webSettings = webView?.settings
        webSettings?.javaScriptEnabled = true
        webSettings?.allowFileAccess = true
        webSettings?.allowContentAccess = true
        webSettings?.domStorageEnabled = true

        webView?.webViewClient = WebViewClient()
        webView?.loadUrl("file:///android_asset/encabezado/slider.html")

        // Obtener y mezclar todas las preguntas, luego seleccionar 5 aleatorias
        val allQuestions = Constants.getQuestions()
        allQuestions.shuffle()
        questionsList = ArrayList(allQuestions.take(5))

        updateQuestion()

        btnNext?.setOnClickListener {
            if (selectedAlternativeIndex == -1) {
                Alerter.create(this)
                    .setTitle("Es obligatorio responder")
                    .setBackgroundColorRes(R.color.gray)
                    .setIcon(R.drawable.warning)
                    .setLayoutGravity(Gravity.BOTTOM)
                    .setDuration(5000)
                    .setTitleAppearance(R.style.AlerterTitleTextAppearance)
                    .setIconSize(R.dimen.custom_icon_size)
                    .show()
            } else {
                val currentQuestion = questionsList[currentQuestionIndex]
                if (selectedAlternativeIndex == currentQuestion.correctAnswerIndex) {
                    totalScore++
                }

                if (currentQuestionIndex < questionsList.size - 1) {
                    currentQuestionIndex++
                    updateQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList.size)
                    intent.putExtra(Constants.SCORE, totalScore)
                    startActivity(intent)
                    finish()
                }

                selectedAlternativeIndex = -1
            }
        }

        tvAlternatives?.let {
            for (optionIndex in it.indices) {
                it[optionIndex].setOnClickListener { view ->
                    selectedAlternativeView(view as TextView, optionIndex)
                }
            }
        }
    }

    private fun updateQuestion() {
        defaultAlternativesView()

        tvQuestion?.text = questionsList[currentQuestionIndex].questionText
        progressBar?.progress = currentQuestionIndex + 1
        tvProgress?.text = "${currentQuestionIndex + 1}/${questionsList.size}"

        for (alternativeIndex in questionsList[currentQuestionIndex].alternatives.indices) {
            tvAlternatives!![alternativeIndex].text = questionsList[currentQuestionIndex].alternatives[alternativeIndex]
        }

        btnNext?.text = "Siguiente"
    }

    private fun defaultAlternativesView() {
        for (alternativeTv in tvAlternatives!!) {
            alternativeTv.typeface = Typeface.DEFAULT
            alternativeTv.setTextColor(Color.parseColor("#7A8089"))
            alternativeTv.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedAlternativeView(option: TextView, index: Int) {
        selectedAlternativeIndex = index

        option.setTextColor(Color.parseColor("#363A43"))
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )

        highlightCorrectAndWrongAnswers(questionsList[currentQuestionIndex])
    }

    private fun highlightCorrectAndWrongAnswers(currentQuestion: Question) {
        for (index in tvAlternatives!!.indices) {
            if (index == currentQuestion.correctAnswerIndex) {
                tvAlternatives!![index].background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    R.drawable.correct_option_border_bg
                )
            } else {
                tvAlternatives!![index].background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    R.drawable.wrong_option_border_bg
                )
            }
        }
    }
}