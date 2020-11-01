package com.example.comprovante.ui.fragment

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.comprovante.R
import com.example.comprovante.database.AppDatabase
import com.example.comprovante.model.Tipo
import com.example.comprovante.utils.Prefs
import kotlinx.android.synthetic.main.fragment_adiciona_tipo.*
import kotlinx.android.synthetic.main.fragment_adiciona_tipo.view.*


class AdcTipoFragment : Fragment() {

    val PREFS_FILENAME = "com.teamtreehouse.colorsarefun.prefs"
//    private var iconeEscolhido : ImageView = TODO()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adiciona_tipo, container, false)
        val context = view.context
        var corEscolhida = ""
        var iconEscolhido = ""
        var iconeEscolhido = view.ic_phone

        view.cor_preta.setOnClickListener {
            corEscolhida = "#B2B2B2"
            mudarCorLayout(corEscolhida, view)
        }
        view.cor_azul.setOnClickListener {
            corEscolhida = "#B2B2FF"
            mudarCorLayout(corEscolhida, view)
        }
        view.cor_azul_claro.setOnClickListener {
            corEscolhida = "#B3D8EC"
            mudarCorLayout(corEscolhida, view)
        }
        view.cor_verde.setOnClickListener {
            corEscolhida = "#B4D1CE"
            mudarCorLayout(corEscolhida, view)
        }
        view.cor_verde_claro.setOnClickListener {
            corEscolhida = "#B7FFB2"
            mudarCorLayout(corEscolhida, view)
        }
        view.cor_amarelo.setOnClickListener {
            corEscolhida = "#F8FFB2"
            mudarCorLayout(corEscolhida, view)
        }
        view.cor_rosa.setOnClickListener {
            corEscolhida = "#FAB2FF"
            mudarCorLayout(corEscolhida, view)
        }
        view.cor_vermelho.setOnClickListener {
            corEscolhida = "#FFB2B2"
            mudarCorLayout(corEscolhida, view)
        }

        view.ic_phone.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_phone
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_phone"
        }

        view.ic_agua.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_agua
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_agua"
        }

        view.ic_carro.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_carro
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_carro"

        }

        view.ic_conta.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_conta
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_conta"

        }

        view.ic_energia.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_energia
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_energia"
        }

        view.ic_home.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_home
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_home"
        }

        view.ic_internet.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_internet
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_internet"

        }

        view.ic_netflix.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_netflix
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_netflix"

        }

        view.ic_seguro.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_seguro
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_seguro"

        }

        view.ic_spotify.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_spotify
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_spotify"

        }

        view.ic_tv.setOnClickListener {
            mudarCorIconePreto(iconeEscolhido, view)
            iconeEscolhido = view.ic_tv
            mudarCorIcone(iconeEscolhido, view)
            iconEscolhido = "ic_tv"

        }

        view.btn_adiciona.setOnClickListener {
            val p : Prefs = Prefs(context)
            iconeEscolhido.background.setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP)
            p.save("code", edit_code.text.toString(), "descricao", edit_descricao.text.toString(), "cor", corEscolhida, "icone", iconEscolhido)

            var tipo = Tipo(
                code = edit_code.text.toString(),
                descricao = edit_descricao.text.toString(),
                cor = corEscolhida,
                icone = iconEscolhido
            )

            val db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "tipo"
            ).build()

            AsyncTask.execute {  var all = db.tipoDao().insertAll(tipo) }



            val lista = ListarTipoFragment()
            val transaction = (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentLayout, lista)
            transaction.addToBackStack("Lista tipo")
            transaction.commit()

        }

        return view

    }

    private fun mudarCorIconePreto(iconeEscolhido: ImageView, view: View) {
        iconeEscolhido.background.setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP)
    }

    private fun mudarCorIcone(iconeEscolhido: ImageView, view: View) {
        iconeEscolhido.background.setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.SRC_ATOP)
    }

    private fun mudarCorLayout(corEscolhida: String, view: View) {

        view.layoutPai.setBackgroundColor(Color.parseColor(corEscolhida))

    }
}