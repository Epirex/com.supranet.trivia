package com.supranet.trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class ResultActivity : AppCompatActivity() {
    private var totalQuestions: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        score = intent.getIntExtra(Constants.SCORE, 0)

        val tvScore: TextView = findViewById(R.id.scoreTv)
        val btnRestart: Button = findViewById(R.id.btnRestart)
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.lottieAnimationView)

        tvScore.text = "Tu puntuación es $score de $totalQuestions"

        // Iniciar la animación
        lottieAnimationView.setAnimation(R.raw.animation) // Asegúrate de que el nombre del archivo coincida
        lottieAnimationView.playAnimation()

        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}