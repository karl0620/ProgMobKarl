package com.example.service_api_72190327

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        lateinit var btnG : Button

        btnG = findViewById(R.id.btnGetAPI)

        btnG.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent (this@ServiceActivity, GetAPIActivity::class.java)
            startActivity(intent)
        })

    }
}