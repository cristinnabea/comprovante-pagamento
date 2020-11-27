@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.example.comprovante.database

import androidx.room.*
import com.example.comprovante.model.Tipo

@Dao
interface tipoDao {

        @Query("SELECT * FROM tipo")
        fun getAll(): List<Tipo>

        @Insert
        fun insertAll(vararg tipos: Tipo)

        @Delete
        fun delete(tipos: Tipo)

}