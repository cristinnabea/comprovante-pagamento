package com.example.comprovante.ui.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
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

        val p: Prefs = Prefs(context)
        code = p.getValueString("code").toString()
        descricao = p.getValueString("descricao").toString()
        cor = p.getValueString("cor").toString()
        icone = p.getValueString("icone").toString()

        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "tipo"
        ).build()

        //var listaTipo: List<Tipo>? = null

        AsyncTask.execute {
            var listaTipo = db.tipoDao().getAll()
            var a = "aaaaa"

            val runnable = Runnable {

                if (!listaTipo.isNullOrEmpty()) {
                    view.imgFundo.visibility = View.GONE
                    view.lista_contas.visibility = View.VISIBLE
                }

                configuraLayout(listaTipo, context, view)
            }

//            Runnable {
//                if (!listaTipo.isNullOrEmpty()) {
//                    view.imgFundo.visibility = View.GONE
//                    view.lista_contas.visibility = View.VISIBLE
//                }
//
//                configuraLayout(listaTipo, context, view)
//            }


        }

        //val tipoLista: List<Tipo> = configuraLista()

//        if (!listaTipo.isNullOrEmpty()) {
//            view.imgFundo.visibility = View.GONE
//            view.lista_contas.visibility = View.VISIBLE
//        }
//
//        if (listaTipo != null) {
//            configuraLayout(listaTipo, context, view)
//        }

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

    private fun configuraLayout(tipoLista: List<Tipo>, context: Context, view: View) {
        view.lista_contas.adapter = ListarTipoAdapter(lista = tipoLista, context = context)
    }

    private fun configuraLista(): List<Tipo> {

        if (code == "null" || descricao == "null" || icone == "") {
            return listOf(
                Tipo(code = "Luz", descricao = "Conta de luz ENEL", cor = "#FFB2B2"),
                Tipo(code = "Agua", descricao = "Conta de agua SABESP", cor = "#F8FFB2")
            )
        } else {

            return listOf(
                Tipo(code = "Luz", descricao = "Conta de luz ENEL", cor = "#FFB2B2"),
                Tipo(code = "Agua", descricao = "Conta de agua SABESP", cor = "#F8FFB2"),
                Tipo(code = code, descricao = descricao, cor = cor, icone = icone)

            )
        }
    }

}