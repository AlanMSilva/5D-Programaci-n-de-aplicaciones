package com.example.modulop2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.modulop2.R
import kotlinx.android.synthetic.main.activity_detalle_contenedor.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetalleContenedorActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var contenedor: Contenedor
    private lateinit var contenedorLiveData: LiveData<Contenedor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_contenedor)

        database = AppDatabase.getDatabase(this)

        val idContenedor = intent.getIntExtra("id",0)

        contenedorLiveData = database.contenedores().get(idContenedor)

        contenedorLiveData.observe(this, Observer {
            contenedor = it

            imageView.setImageResource(contenedor.imagen)
            detalle_contenedor.text = "No. ${contenedor.ncontenedor}"
            detalle_origen.text = contenedor.origen
            detalle_destino.text = contenedor.destino
            detalle_descripcion.text = contenedor.descripcion

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contenedor_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.edit_item ->{
                val intent = Intent(this, NuevoContenedorActivity::class.java)
                intent.putExtra("contenedor",contenedor)
                startActivity(intent)
            }

            R.id.delete_item->{
                contenedorLiveData.removeObservers(this)

                CoroutineScope(Dispatchers.IO).launch {
                    database.contenedores().delete(contenedor)
                    this@DetalleContenedorActivity.finish()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}