package com.supranet.trivia

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/tapa/slider.html")

        // Agrega un OnTouchListener al WebView
        webView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
            true
        }
    }
}