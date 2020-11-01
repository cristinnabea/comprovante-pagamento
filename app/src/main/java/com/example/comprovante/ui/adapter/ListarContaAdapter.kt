package com.example.comprovante.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.comprovante.R
import com.example.comprovante.model.Conta
import com.example.comprovante.model.Tipo
import kotlinx.android.synthetic.main.item_conta.view.*

class ListarContaAdapter(
    private val lista: List<Conta>,
    private val context: Context
) : BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Conta {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_conta, parent, false)

        val item = lista[position]
        var guarda: Boolean = false

        view.txt_mes_conta.text = item.data

        view.imgSeta.setOnClickListener {
            if (guarda) {
                guarda = false
                view.images_conta.visibility = View.GONE
                view.imgSeta.rotation = 0f
            } else {
                guarda = true
                view.images_conta.visibility = View.VISIBLE
                view.imgSeta.rotation = 180.0f
            }
        }

        return view
    }
}