package com.example.comprovante.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream

fun encodeImage(bm: Bitmap): String? {
    val baos = ByteArrayOutputStream()
    bm.compress(Bitmap.CompressFormat.PNG, 100, baos)
    val b = baos.toByteArray()
    return Base64.encodeToString(b, Base64.DEFAULT)
}

fun decodeBase64IntoBitmap(s: String?): Bitmap {
    val imageBytes : ByteArray? = Base64.decode(s, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes?.count()!!)
}
