package br.edu.buynow

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MostrarProdutos : AppCompatActivity() {

    private lateinit var rvProdutos: RecyclerView
    private lateinit var produtoListAdapter: ProdutoListAdapter
    private val listaProdutos = mutableListOf<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_produtos)

        rvProdutos = findViewById(R.id.rvProdutos)
        rvProdutos.layoutManager = LinearLayoutManager(this)
        produtoListAdapter = ProdutoListAdapter(listaProdutos)
        rvProdutos.adapter = produtoListAdapter

        val db = FirebaseFirestore.getInstance()

        // Buscar produtos do Firestore
        db.collection("Produtos")
            .get()
            .addOnSuccessListener { result ->
                // Verificar se a consulta retornou algum dado
                if (result.isEmpty) {
                    Toast.makeText(this, "Nenhum produto encontrado", Toast.LENGTH_SHORT).show()
                } else {
                    // Limpar a lista antes de adicionar os novos produtos
                    listaProdutos.clear()
                    for (document in result) {
                        val nome = document.getString("nome") ?: "Sem nome"
                        val categoria = document.getString("categoria") ?: "Sem categoria"

                        // Tratar o campo 'preco' para aceitar diferentes tipos de dados
                        val preco: String = when (val precoField = document.get("preco")) {
                            is String -> precoField  // Caso seja String
                            is Number -> precoField.toString()  // Caso seja número (Double ou Integer)
                            else -> "Sem preço"
                        }

                        listaProdutos.add(Produto(nome, categoria, preco))
                    }

                    // Notificar o adaptador que os dados foram atualizados
                    produtoListAdapter.notifyDataSetChanged()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Erro ao carregar produtos: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
