package com.example.menuwebviewmad8

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var addressInput: EditText
    private lateinit var pageStatus: TextView
    private lateinit var progressBar: ProgressBar

    companion object {
        private const val HOME_URL = "https://www.google.com"
        private const val WIKIPEDIA_URL = "https://www.wikipedia.org"
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Web Explorer"

        webView = findViewById(R.id.webView)
        addressInput = findViewById(R.id.addressInput)
        pageStatus = findViewById(R.id.pageStatus)
        progressBar = findViewById(R.id.progressBar)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.loadsImagesAutomatically = true

        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: android.graphics.Bitmap?
            ) {
                progressBar.visibility = View.VISIBLE
                pageStatus.text = "Loading page..."
            }

            override fun onPageFinished(
                view: WebView?,
                url: String?
            ) {
                progressBar.visibility = View.GONE

                pageStatus.text = if (url.isNullOrBlank()) {
                    "Ready"
                } else {
                    "Loaded • ${url.substringAfter("://").substringBefore("/")}"
                }
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: android.webkit.WebResourceError?
            ) {
                if (request?.isForMainFrame == true) {
                    pageStatus.text =
                        "Could not load page. Check your internet connection."
                }
            }
        }

        webView.webChromeClient = object : WebChromeClient() {

            override fun onProgressChanged(
                view: WebView?,
                newProgress: Int
            ) {
                progressBar.progress = newProgress

                progressBar.visibility =
                    if (newProgress in 1..99) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
            }
        }

        findViewById<Button>(R.id.goButton).setOnClickListener {
            openAddress()
        }

        findViewById<Button>(R.id.homeButton).setOnClickListener {
            addressInput.setText("")
            loadPage(HOME_URL)
        }

        findViewById<Button>(R.id.wikiButton).setOnClickListener {
            addressInput.setText("")
            loadPage(WIKIPEDIA_URL)
        }

        findViewById<Button>(R.id.backButton).setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                Toast.makeText(
                    this,
                    "No previous page",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        findViewById<Button>(R.id.forwardButton).setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
            } else {
                Toast.makeText(
                    this,
                    "No next page",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        addressInput.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_GO ||
                actionId == EditorInfo.IME_ACTION_DONE
            ) {
                openAddress()
                true
            } else {
                false
            }
        }

        if (savedInstanceState == null) {
            loadPage(HOME_URL)
        } else {
            webView.restoreState(savedInstanceState)
        }
    }

    private fun openAddress() {

        var address = addressInput.text.toString().trim()

        if (address.isEmpty()) {
            addressInput.error = "Enter website or search"
            return
        }

        if (!address.startsWith("http://") &&
            !address.startsWith("https://")
        ) {

            address = if (
                address.contains(".") &&
                !address.contains(" ")
            ) {
                "https://$address"
            } else {
                "https://www.google.com/search?q=" +
                        android.net.Uri.encode(address)
            }
        }

        loadPage(address)
    }

    private fun loadPage(url: String) {
        webView.loadUrl(url)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.menu_home -> {
                addressInput.setText("")
                loadPage(HOME_URL)
            }

            R.id.menu_wikipedia -> {
                addressInput.setText("")
                loadPage(WIKIPEDIA_URL)
            }

            R.id.menu_refresh -> {
                webView.reload()
            }

            R.id.menu_about -> {
                showAbout()
            }

            R.id.menu_exit -> {
                finish()
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

        return true
    }

    private fun showAbout() {

        AlertDialog.Builder(this)
            .setTitle("About Web Explorer")
            .setMessage(
                "Experiment 8: Implement Menus and WebView\n\n" +
                        "Student: Tejas Sunil Waske\n" +
                        "USN: 25MCAR0189\n\n" +
                        "This app demonstrates Android Options Menu, " +
                        "WebView browsing, address navigation, " +
                        "page history and refresh."
            )
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    @Deprecated("Use system back navigation")
    override fun onBackPressed() {
        if (::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        if (::webView.isInitialized) {
            webView.stopLoading()
            webView.destroy()
        }
        super.onDestroy()
    }
}