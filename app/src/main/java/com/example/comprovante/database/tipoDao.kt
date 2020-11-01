@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.example.comprovante.database

import androidx.room.*
import com.example.comprovante.model.Tipo

@Dao
interface tipoDao {

//        @Query("SELECT * FROM")
//        fun getAll(): List<Tipo>

        @Query("SELECT * FROM tipo")
        fun getAll(): List<Tipo>

       // @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1")
//        fun findByName(first: String, last: String): User

        @Insert
        fun insertAll(vararg tipos: Tipo)

        @Delete
        fun delete(tipo: Tipo)

}