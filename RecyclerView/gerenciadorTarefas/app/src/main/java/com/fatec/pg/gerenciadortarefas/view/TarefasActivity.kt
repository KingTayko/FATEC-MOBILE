package com.fatec.pg.gerenciadortarefas.view

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fatec.pg.gerenciadortarefas.R
import com.fatec.pg.gerenciadortarefas.adapter.TarefaAdapter
import com.fatec.pg.gerenciadortarefas.dao.TarefaDaoImpl

class TarefasActivity : AppCompatActivity() {

    val dao = TarefaDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefas)

        Log.i("TAREFA", dao.obterTarefa().toString())

        val rvTarefas = findViewById<RecyclerView>(R.id.rcv_tarefas)
        val tarefas = dao.obterTarefa()

        rvTarefas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTarefas.adapter = TarefaAdapter(tarefas)
    }
}