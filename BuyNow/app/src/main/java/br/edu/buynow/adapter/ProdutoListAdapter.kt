package br.edu.buynow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Produto(val nome: String, val categoria: String, val preco: String)

class ProdutoListAdapter(private val listaProdutos: List<Produto>) : RecyclerView.Adapter<ProdutoListAdapter.ProdutoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_produto_list, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.bind(produto)
    }

    override fun getItemCount(): Int {
        return listaProdutos.size
    }

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomeTextView: TextView = itemView.findViewById(R.id.txtNome)
        private val categoriaTextView: TextView = itemView.findViewById(R.id.txtCategoria)
        private val precoTextView: TextView = itemView.findViewById(R.id.txtPreco)

        fun bind(produto: Produto) {
            nomeTextView.text = produto.nome
            categoriaTextView.text = produto.categoria
            precoTextView.text = produto.preco
        }
    }
}
