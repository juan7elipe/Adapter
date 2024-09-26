package br.unipar.adapter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDeAlunos = mutableListOf<Alunos>()
    private var contagemAlunos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edAluno = findViewById<EditText>(R.id.edAluno)
        val edEscolha = findViewById<EditText>(R.id.edEscolha)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listView = findViewById<ListView>(R.id.listViewAlunos)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val btnZerar = findViewById<Button>(R.id.btnZerar)

        val adapter = ListaAdapter(this, listaDeAlunos)
        listView.adapter = adapter

        btnInserir.setOnClickListener {
            val nomeAluno = edAluno.text.toString()
            val areaEscolha = edEscolha.text.toString()
            val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            if (nomeAluno.isNotEmpty() && areaEscolha.isNotEmpty()) {
                val novoAluno = Alunos(nomeAluno, areaEscolha, dataAtual)
                listaDeAlunos.add(novoAluno)
                contagemAlunos++
                adapter.notifyDataSetChanged()

                Log.d("MainActivity", "Aluno adicionado: ${novoAluno.nome}") // Log para depuração
                resultado.text = "Quantidade de Alunos: $contagemAlunos"
                edAluno.text.clear() // Limpa campo
                edEscolha.text.clear() // Limpa campo

            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnZerar.setOnClickListener {
            listaDeAlunos.clear()
            adapter.notifyDataSetChanged()
            contagemAlunos = 0
            resultado.text = "Quantidade de Alunos: $contagemAlunos"
            edAluno.text.clear()
            edEscolha.text.clear()
            Toast.makeText(this, "Lista zerada", Toast.LENGTH_SHORT).show()
        }
    }
}

