package com.example.interfazdiseo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_article : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_article)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnVolver: Button = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener{
            //finish elimina o cierra la actividad actual
            finish()
        }
    }
    fun btnLista(view: View) {
        //se configura
        var intent= Intent(application, activity_list::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }
}