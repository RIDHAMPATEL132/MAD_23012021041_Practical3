package com.example.mad_23012021041_practical3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val urlBtn = findViewById<Button>(R.id.urlbtn)
        val urllink = findViewById<EditText>(R.id.urlEditText)
        urlBtn.setOnClickListener{
            val urldata = urllink.text.toString()
            if(urldata.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                startActivity(intent)
            }
        }

        val callBtn = findViewById<Button>(R.id.callbtn)
        val phoneno = findViewById<EditText>(R.id.phoneEditText)
        callBtn.setOnClickListener{
            val number = phoneno.text.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intent)
        }

        val callLogBtn = findViewById<Button>(R.id.calllogbtn)
        callLogBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = CallLog.Calls.CONTENT_URI
            startActivity(intent)
        }

        val galleryBtn = findViewById<Button>(R.id.gallerybtn)
        galleryBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = "image/*"
            startActivity(intent)
        }

        val cameraBtn = findViewById<Button>(R.id.camerabtn)
        cameraBtn.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        val alarmBtn = findViewById<Button>(R.id.alarmbtn)
        alarmBtn.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        }

        val loginBtn = findViewById<Button>(R.id.loginbtn)
        loginBtn.setOnClickListener {
            val intent = Intent(this, loginpage::class.java)
            startActivity(intent)
        }

    }
}