package com.news.app.view.activity

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.news.R
import com.news.app.constants.ConstantsApp
import com.squareup.picasso.Picasso


/**
 * Created by Atif Qamar on 12-11-2020.
 */

class NewsDescriptionActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var webView: WebView
    lateinit var progressBar: ProgressBar
    private var imageURL: String = ""
    private var webURL: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_description)
        intUI()
    }

    private fun intUI() {
        imageView = findViewById(R.id.im_image)
        webView = findViewById(R.id.webView)
        progressBar = findViewById(R.id.progressBar);
        getDataFromIntent()
    }

    private fun getDataFromIntent() {
        val bundleExtras = intent.extras
        if (bundleExtras != null) {
            imageURL = bundleExtras.getString(ConstantsApp.imageURL).toString()
            webURL = bundleExtras.getString(ConstantsApp.webURL).toString()
            displayImage(imageURL)
            displayWeb(webURL)
        }
    }

    private fun displayImage(imageURL: String) {
        Picasso.get()
            .load(imageURL)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(imageView)
    }

    private fun displayWeb(webURL: String) {
        webView.webViewClient = WebViewClient()
        webView.loadUrl(webURL)
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
    }

}

