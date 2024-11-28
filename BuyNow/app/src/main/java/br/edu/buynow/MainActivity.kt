package br.edu.buynow

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.buynow.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = FirebaseFirestore.getInstance()

        binding.btnCadastro.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val categoria = binding.edtCategoria.text.toString()
            val preco = binding.edtPreco.text.toString().toDoubleOrNull() ?: 0.0 //por ele ser um double, eu tenho q por ele como double dnv

            //conectar as variaveis ao banco de dados
            val item = hashMapOf(
                "nome" to nome,
                "categoria" to categoria,
                "preco" to preco
            )

            //adicionando itens a colecao
            db.collection("Produtos")
                .add(item)
                .addOnSuccessListener {
                    Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Falha no salvamento da consulta!!!", Toast.LENGTH_SHORT)
                        .show()
                }

            //limpando os editText
            binding.edtNome.text.clear()
            binding.edtCategoria.text.clear()
            binding.edtPreco.text.clear()

        }

        binding.btnMostrar.setOnClickListener {
            val intent = Intent(this, MostrarProdutos::class.java)
            startActivity(intent)
        }


    }


}