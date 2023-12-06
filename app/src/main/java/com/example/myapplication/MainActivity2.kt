package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var webView: WebView
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        editText = findViewById(R.id.edit_text)
        button = findViewById(R.id.button)
        webView = findViewById(R.id.web_view)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button.setOnClickListener {
            val runnable:Runnable = Runnable {
                handler = Handler(Looper.getMainLooper())
                val url = editText.text.toString()

                if (url.isNotEmpty()) {
                    handler.post (Runnable{
                        webView.loadUrl(url)
                        Toast.makeText(
                            applicationContext,
                            "Данные загружены",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                }else {
                    webView.loadData("Сайт не указан", "text/html", "UTF-8")
                }
            }
            val th:Thread = Thread(runnable)
            th.start()

        }
        button2.setOnClickListener{
            val intent: Intent = Intent(this@MainActivity2,MainActivity3::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener{
            val intent: Intent = Intent(this@MainActivity2,MainActivity4::class.java)
            startActivity(intent)
        }
    }
}