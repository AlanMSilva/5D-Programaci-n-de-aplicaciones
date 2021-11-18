package com.example.modulop2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modulop2.R
import kotlinx.android.synthetic.main.activity_nuevo_contenedor.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoContenedorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_contenedor)

        var idContenedor: Int? = null

        if (intent.hasExtra("contenedor")){
            val contenedor = intent.extras?.getSerializable("contenedor") as Contenedor

            contenedor_new.setText(contenedor.ncontenedor.toString())
            origen_new.setText(contenedor.origen)
            destino_new.setText(contenedor.destino)
            descripcion_new.setText(contenedor.descripcion)
            idContenedor = contenedor.idContenedor

        }

        val database = AppDatabase.getDatabase(this)

        save_btn.setOnClickListener {
            val numcontenedor = contenedor_new.text.toString().toInt()
            val origen = origen_new.text.toString()
            val destino = destino_new.text.toString()
            val descripcion = descripcion_new.text.toString()

            val contenedor = Contenedor(numcontenedor,origen,destino,descripcion,R.drawable.contenedor)

            if (idContenedor != null){
                CoroutineScope(Dispatchers.IO).launch {
                    contenedor.idContenedor = idContenedor

                    database.contenedores().update(contenedor)
                    this@NuevoContenedorActivity.finish()
                }
            }else {
                CoroutineScope(Dispatchers.IO).launch {
                    database.contenedores().insertAll(contenedor)

                    this@NuevoContenedorActivity.finish()
                }
            }
        }
    }
}