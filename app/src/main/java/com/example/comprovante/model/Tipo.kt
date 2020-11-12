package com.example.comprovante.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tipo")
class Tipo(
    @PrimaryKey
    val code: String,
    val descricao: String,
    val cor: String,
    val icone: String? //= "ic_conta"
) : Serializable


