package com.example.interfazdiseo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interfazdiseo.adapters.adapterNews
import com.example.interfazdiseo.models.news

class activity_news : AppCompatActivity() {
    lateinit var listaNoticias:MutableList<news>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //se inicializa el mutablelist
        listaNoticias = mutableListOf()
        //se agrega elemtos
        listaNoticias.add(news("Versace en los Oscar 2024","Versace ha diseñado varios trajes personalizados para los invitados a los Premios de la Academia.", R.drawable.vestidos_oscar_2024))
        listaNoticias.add(news("Versace en la Met Gala","El vestido de Anne Hathaway combinaba elementos de Chanel de Karl Lagerfeld y Versace.", R.drawable.versace_met))
        listaNoticias.add(news("Colaboraciones Destacadas","Versace colaboró con marcas como Fendi y H&M.", R.drawable.versace_finde))
        listaNoticias.add(news("Cambio de Propiedad","En 2018, Michael Kors adquirió Versace.", R.drawable.michael))
        listaNoticias.add(news("Presencia en la moda masculina"," Versace consolidó su presencia en la moda masculina.", R.drawable.moda_masculina))
        listaNoticias.add(news("Enfoque en sostenibilidad","Versace toma medidas para ser más eco-friendly y éticamente responsables en moda.",R.drawable.ecofriendly))
        listaNoticias.add(news("Lanzamientos de productos innovadores","Versace lanza productos (fragancias y accesorio de moda).", R.drawable.perfume))

        //se crea y asocia una varibale con el objeto de la vista
        var recycler=findViewById<RecyclerView>(R.id.RVNews)
        recycler.layoutManager = LinearLayoutManager(applicationContext)
        //se crea el adpatador
        var adapterNews=adapterNews(listaNoticias,applicationContext)
        //se asocia el adaptador con objeto
        recycler.adapter=adapterNews

        var btnVolver: Button = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener{
            //finish elimina o cierra la actividad actual
            finish()
        }

    }
    fun btnInicio(view: View) {
        //se configura
        var intent= Intent(application, MainActivity::class.java)
        //se ejecuta la actividad
        startActivity(intent)
    }
}