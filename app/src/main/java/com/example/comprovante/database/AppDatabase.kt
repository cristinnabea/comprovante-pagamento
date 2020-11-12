package com.example.comprovante.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.comprovante.model.Tipo

@Database(entities = arrayOf(Tipo::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tipoDao(): tipoDao
}