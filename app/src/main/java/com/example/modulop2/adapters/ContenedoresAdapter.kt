package com.example.modulop2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.modulop2.R
import com.example.modulop2.activities.Contenedor
import kotlinx.android.synthetic.main.item_contenedor.view.*

class ContenedoresAdapter(private val mContext: Context, private val listaContenedores: List<Contenedor>): ArrayAdapter<Contenedor>(mContext, 0  , listaContenedores) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_contenedor, parent, false)

        val contenedor = listaContenedores[position]

        layout.ncontenedor.text = "No. ${contenedor.ncontenedor}"
        layout.origen.text = contenedor.origen
        layout.destino.text = contenedor.destino

        return layout
    }
}