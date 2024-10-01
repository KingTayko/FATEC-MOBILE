package com.fatec.pg.gerenciadortarefas.dao

import com.fatec.pg.gerenciadortarefas.model.Tarefa

class TarefaDaoImpl:TarefaDao {
    companion object {
        private val tarefas = mutableListOf<Tarefa>()
    }

    override fun adicionarTarefa(tarefa: Tarefa) {
        Companion.tarefas.add(tarefa)
    }

    override fun obterTarefa(): List<Tarefa> {
        return Companion.tarefas
    }
}