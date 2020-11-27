package com.example.comprovante.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.comprovante.R
import com.example.comprovante.database.AppDatabase
import com.example.comprovante.model.Conta
import com.example.comprovante.model.Tipo
import com.example.comprovante.ui.adapter.ListarContaAdapter
import com.example.comprovante.ui.adapter.ListarTipoAdapter
import com.example.comprovante.utils.decodeBase64IntoBitmap
import kotlinx.android.synthetic.main.fragment_lista_conta.view.*
import kotlinx.android.synthetic.main.fragment_lista_conta.view.floating_tipo_conta
import kotlinx.android.synthetic.main.fragment_lista_conta.view.lista_contas
import kotlinx.android.synthetic.main.fragment_lista_tipo.view.*

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
//
//        val drawable1 = ContextCompat.getDrawable(
//            context,
//            context.resources.getIdentifier(tipo.icone, "drawable", context.getPackageName())
//        )
        view.img_cabecalho.setImageBitmap(decodeBase64IntoBitmap(tipo.icone))
        view.txt_item_conta2.text = tipo.code
        view.txt_item_descricao.text = tipo.descricao
        view.constraintLayout2.setBackgroundColor(Color.parseColor(tipo.cor))

        val listConta: List<Conta> = listOf(Conta("Setembro 2020", 0, 0, "10/10/2020", "0", "0", "0"))

        view.floating_tipo_conta.setOnClickListener {
            val adcContaFragment = AdcContaFragment()
            val transaction =
                (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentLayout, adcContaFragment)
            transaction.addToBackStack("Adicionar Conta")
            transaction.commit()
        }

        view.lista_contas.adapter = ListarContaAdapter(lista = listConta, context = context)


        return view
    }
}