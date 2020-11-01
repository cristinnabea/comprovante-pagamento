package com.example.comprovante.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.comprovante.R
import com.example.comprovante.model.Tipo
import com.example.comprovante.ui.fragment.ListarContaFragment
import kotlinx.android.synthetic.main.item_lista_tipo.view.*


class ListarTipoAdapter(
    private val lista: List<Tipo>,
    private val context: Context
) : BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Tipo {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_lista_tipo, parent, false)

        val list = lista[position]

//        if (list.icone == "sem icone" || list.icone == "null") {
//
//        } else {
//            val drawable1 = ContextCompat.getDrawable(
//                context,
//                context.resources.getIdentifier(list.icone, "drawable", context.getPackageName())
//            )
//            view.imgSeta.setImageDrawable(drawable1)
//        }

        view.txt_mes_conta.text = list.code
        view.txtDetalhe.text = list.descricao

        view.fundo2.setBackgroundColor(Color.parseColor(list.cor))

        view.fundo2.setOnClickListener {
            val listaConta = ListarContaFragment()

            val args = Bundle()
            args.putSerializable("item" , list)

            listaConta.arguments = args
            val transaction =
                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentLayout, listaConta)
            transaction.addToBackStack("Lista conta")
            transaction.commit()
        }


        return view
    }
}