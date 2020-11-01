package com.example.comprovante.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.comprovante.R
import com.example.comprovante.database.AppDatabase
import com.example.comprovante.model.Conta
import com.example.comprovante.model.Tipo
import com.example.comprovante.ui.adapter.ListarContaAdapter
import com.example.comprovante.ui.adapter.ListarTipoAdapter
import kotlinx.android.synthetic.main.fragment_lista_conta.view.*

class ListarContaFragment : Fragment() {

    var code: String = ""
    var descricao = ""
    var cor = ""
    var icone = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista_conta, container, false)
        val context = view.context


        var arguments = this.arguments
        var tipo = arguments?.getSerializable("item") as Tipo

        val drawable1 = ContextCompat.getDrawable(
            context,
            context.resources.getIdentifier(tipo.icone, "drawable", context.getPackageName())
        )
        view.img_cabecalho.setImageDrawable(drawable1)
        view.txt_item_conta2.text = tipo.code
        view.txt_item_descricao.text = tipo.descricao
        view.constraintLayout2.setBackgroundColor(Color.parseColor(tipo.cor))

        val listConta: List<Conta> = listOf(Conta("Setembro 2020"))

        view.lista_contas.adapter = ListarContaAdapter(lista = listConta, context = context)


        return view
    }
}