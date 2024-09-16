package com.example.appcadastrolivro.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appcadastrolivro.R

class ShowActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_activity)

        val bundle = intent.extras
        val livro = bundle?.getString("Livro")
        val autor = bundle?.getString("Autor")

        val textLivro = findViewById<TextView>(R.id.txt_livro)
        val textAutor = findViewById<TextView>(R.id.txt_autor)

        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        if (livro.toString().isEmpty() || autor.toString().isEmpty()) {
            Toast.makeText(this, "Dados Insuficientes", Toast.LENGTH_SHORT).show()
        } else {
            textLivro.text = livro
            textAutor.text = autor


            btnVoltar.setOnClickListener {
                finish()
            }

        }

    }
}