package br.unipar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class ListaAdapter(private val context: Context,
                   private val listaAlunos: MutableList<Alunos>) :
    ArrayAdapter<Alunos>(context, 0, listaAlunos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_alunos, parent, false)

        val aluno = listaAlunos[position]

        val txtAlunos = view.findViewById<TextView>(R.id.txtAlunos)
        val txtAreaEscolha = view.findViewById<TextView>(R.id.txtAreaEscolha)
        val txtData = view.findViewById<TextView>(R.id.txtData)

        txtAlunos.text = aluno.nome
        txtAreaEscolha.text = aluno.area
        txtData.text = aluno.data

        return view
    }
}
