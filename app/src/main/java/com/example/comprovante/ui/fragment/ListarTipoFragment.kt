package com.example.comprovante.ui.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room

import com.example.comprovante.R
import com.example.comprovante.database.AppDatabase
import com.example.comprovante.model.Tipo
import com.example.comprovante.ui.adapter.ListarTipoAdapter
import com.example.comprovante.utils.Prefs
import kotlinx.android.synthetic.main.fragment_lista_tipo.view.*


class ListarTipoFragment : Fragment() {

    var code: String = ""
    var descricao = ""
    var cor = ""
    var icone = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_lista_tipo, container, false)
        val context = view.context

        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "tipo"
        ).build()

        AsyncTask.execute {
            var listaTipo = db.tipoDao().getAll()
            var a = "aaaaa"

            if (listaTipo.isNullOrEmpty()) {
                view.imgFundo.visibility = View.VISIBLE
                view.lista_contas.visibility = View.GONE
            } else {
                activity?.runOnUiThread(java.lang.Runnable {
                    view.lista_contas.visibility = View.VISIBLE
                    view.imgFundo.visibility = View.GONE
                    view.lista_contas.adapter =
                        ListarTipoAdapter(lista = listaTipo, context = context)
//                (view.lista_contas.adapter as ListarTipoAdapter).notifyDataSetChanged();
                })
            }

        }

        view.floating_tipo_conta.setOnClickListener {
            val adcTipoFragment = AdcTipoFragment()
            val transaction =
                (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentLayout, adcTipoFragment)
            transaction.addToBackStack("Adicionar Tipo")
            transaction.commit()
        }

        return view

    }

}