package com.fatec.pg.gerenciadortarefas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fatec.pg.gerenciadortarefas.R
import com.fatec.pg.gerenciadortarefas.dao.TarefaDaoImpl
import com.fatec.pg.gerenciadortarefas.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val dao = TarefaDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabLista  = findViewById<FloatingActionButton>(R.id.fab_lista)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtDesc = findViewById<EditText>(R.id.edt_desc)

        btnCadastrar.setOnClickListener {

            val nome = edtNome.text.toString()
            val desc = edtDesc.text.toString()

            val tarefa = Tarefa(nome, desc)

            dao.adicionarTarefa(tarefa)

            Toast.makeText(this, "Tarefas Registrada com Sucesso!", Toast.LENGTH_SHORT).show()

            edtNome.text.clear()
            edtDesc.text.clear();
        }

        fabLista.setOnClickListener {
            val intent = Intent(this, TarefasActivity::class.java)
            startActivity(intent)
        }

    }
}