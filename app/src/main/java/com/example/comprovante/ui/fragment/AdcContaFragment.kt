package com.example.comprovante.ui.fragment

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.comprovante.R
import kotlinx.android.synthetic.main.fragment_adicionar_conta.*
import kotlinx.android.synthetic.main.fragment_adicionar_conta.view.*
import java.io.File


class AdcContaFragment : Fragment() {

    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_FILE = 111
    var isImage1 = false
    var isImage2 = false
    var isImage3 = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adicionar_conta, container, false)
        val context = view.context





        view.image1.setOnClickListener {
            dispatchTakePictureIntent()
//            escolherArquivo(context)
            isImage1 = true
        }

        view.image2.setOnClickListener {
            dispatchTakePictureIntent()
            isImage2 = true
        }

        view.image3.setOnClickListener {
            dispatchTakePictureIntent()
            isImage3 = true
        }


        return view
    }

    private fun escolherArquivo(context: Context?) {
        val builder = context?.let { AlertDialog.Builder(it) }
        builder?.setMessage("Arquivo ou camera?")
            ?.setPositiveButton("camera",
                DialogInterface.OnClickListener { dialog, id ->
                    dispatchTakePictureIntent()
                })
            ?.setNegativeButton("arquivo",
                DialogInterface.OnClickListener { dialog, id ->
                    abrirArquivos()
                })
        // Create the AlertDialog object and return it
        builder?.create()
        builder?.show()
    }

    private fun abrirArquivos() {

        val intent = Intent()
            .setType("*/*")
            .setAction(Intent.ACTION_OPEN_DOCUMENT)

        startActivityForResult(Intent.createChooser(intent, "Select a file"), REQUEST_FILE)
    }


    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            context?.packageManager?.let {
                takePictureIntent.resolveActivity(it)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap

            if (isImage1) {
                image1.setBackgroundColor(R.color.colorWhite.toInt())
                image1.setImageBitmap(imageBitmap)
                isImage1 = false
            }
            if (isImage2) {
                image2.setBackgroundColor(R.color.colorWhite.toInt())
                image2.setImageBitmap(imageBitmap)
                isImage2 = false
            }
            if (isImage3) {
                image3.setBackgroundColor(R.color.colorWhite.toInt())
                image3.setImageBitmap(imageBitmap)
                isImage3 = false
            }

            var a = "aaaaa"
        }

        if (requestCode == REQUEST_FILE && resultCode == RESULT_OK) {
            val selectedFile = data?.data


        }
    }
}



