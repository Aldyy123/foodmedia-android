package com.example.food2

import android.app.Activity
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    private val url = "https://penggerak.foodmedia.id"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myWebView: WebView = findViewById(R.id.webView)
        myWebView.loadUrl(url)
        val webViewSetting = myWebView.settings
        webViewSetting.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()
        webViewSetting.setAppCacheEnabled(true)
        webViewSetting.saveFormData = true
        webViewSetting.savePassword = true
        webViewSetting.domStorageEnabled = true
        webViewSetting.setNeedInitialFocus(true)
        webViewSetting.userAgentString = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        var myWebView: WebView = findViewById(R.id.webView)
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()){
            myWebView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}

