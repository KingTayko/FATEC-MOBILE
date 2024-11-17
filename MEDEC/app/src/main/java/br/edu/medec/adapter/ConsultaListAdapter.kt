package br.edu.medec.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.medec.R
import br.edu.medec.dao.Consultas

class ConsultaListAdapter(val consultaList: List<Consultas>) : RecyclerView.Adapter<ConsultaListAdapter.ConsultaViewHodler>() {
    class ConsultaViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewnome: TextView = itemView.findViewById(R.id.nome)
        val textViewidade: TextView = itemView.findViewById(R.id.idade)
        val textViewdata: TextView = itemView.findViewById(R.id.data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultaViewHodler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_consulta, parent, false)
        return ConsultaViewHodler(view)
    }


    override fun onBindViewHolder(holder: ConsultaViewHodler, position: Int) {

        holder.textViewnome.text = consultaList[position].nome
        holder.textViewidade.text = consultaList[position].idade.toString()
        holder.textViewdata.text = consultaList[position].data.toString()
    }

    override fun getItemCount(): Int {
        return consultaList.size
    }



}