package com.example.comprovante.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.comprovante.model.Conta

interface contaDao {

    @Query("SELECT * FROM conta")
    fun getAll(): List<Conta>

    @Insert
    fun insertAll(vararg contas: Conta)

    @Delete
    fun delete(contas: Conta)
}