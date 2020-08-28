package com.github.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "Testando esse CEP 55555-4444"
        val pattern = Pattern.compile("\\d{5}([\\-]\\d{4})?")
        val scheme = "igor://"
        Linkify.addLinks(textView, pattern, scheme)
    }

}