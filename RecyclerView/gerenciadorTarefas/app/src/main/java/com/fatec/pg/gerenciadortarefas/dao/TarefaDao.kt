package com.fatec.pg.gerenciadortarefas.dao

import com.fatec.pg.gerenciadortarefas.model.Tarefa

interface TarefaDao {
    fun adicionarTarefa(tarefa: Tarefa)
    fun obterTarefa(): List<Tarefa>
}