package com.fatec.pg.gerenciadortarefas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.fatec.pg.gerenciadortarefas.R
import com.fatec.pg.gerenciadortarefas.model.Tarefa
import org.w3c.dom.Text

class TarefaAdapter(private val tarefas:List<Tarefa>): RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome)
        val txvDesc: TextView = itemView.findViewById(R.id.txv_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.txvNome.text = tarefa.nome
        holder.txvDesc.text = tarefa.descricao
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }
}