package com.example.comprovante.model

import androidx.room.Entity
import java.io.Serializable
@Entity(tableName = "conta")
class Conta (
    val dataVencimento: String,
    val id: Int,
    val valor: Int,
    val dataPagamento: String,
    val image1: String,
    val image2: String,
    val image3: String
) : Serializable