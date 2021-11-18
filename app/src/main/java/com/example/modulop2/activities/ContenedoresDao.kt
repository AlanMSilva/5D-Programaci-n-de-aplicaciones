package com.example.modulop2.activities

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContenedoresDao {

    @Query("SELECT * FROM contenedores")
    fun getAll(): LiveData<List<Contenedor>>

    @Query("SELECT * FROM contenedores WHERE idContenedor = :id")
    fun get(id: Int): LiveData<Contenedor>

    @Insert
    fun insertAll(vararg contenedor: Contenedor)

    @Update
    fun update(contenedor: Contenedor)

    @Delete
    fun delete(contenedor: Contenedor)
}