package com.example.modulop2.activities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contenedores")
class Contenedor (
    val ncontenedor:Int,
    val origen: String,
    val destino: String,
    val descripcion: String,
    val imagen: Int,
    @PrimaryKey(autoGenerate = true)
    var idContenedor:Int = 0
    ) : Serializable