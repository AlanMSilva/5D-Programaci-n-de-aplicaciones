package com.example.modulop2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.modulop2.R
import com.example.modulop2.adapters.ContenedoresAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaContenedores = emptyList<Contenedor>()

        var database = AppDatabase.getDatabase(this)

        database.contenedores().getAll().observe(this, Observer {
            listaContenedores = it

            val adapter = ContenedoresAdapter(this, listaContenedores)
            lista.adapter = adapter
        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetalleContenedorActivity::class.java)
            intent.putExtra("id", listaContenedores[position].idContenedor)
            startActivity(intent)
        }

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, NuevoContenedorActivity::class.java)
            startActivity(intent)
        }
        floatingActionButton2.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}