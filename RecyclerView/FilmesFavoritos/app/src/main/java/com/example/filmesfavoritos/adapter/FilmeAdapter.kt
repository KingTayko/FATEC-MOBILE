package com.example.filmesfavoritos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesfavoritos.R
import com.example.filmesfavoritos.model.Filme

class FilmeAdapter(private val filmes:List<Filme>):RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txvTitulo: TextView = itemView.findViewById(R.id.txv_titulo)
        val txvDiretor: TextView = itemView.findViewById(R.id.txv_diretor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txvTitulo.text = filme.titulo
        holder.txvDiretor.text = filme.diretor
    }

    override fun getItemCount(): Int {
        return filmes.size
    }
}