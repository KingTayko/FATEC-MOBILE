package com.example.filmesfavoritos.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.filmesfavoritos.R
import com.example.filmesfavoritos.dao.FilmeDaoImpl
import com.example.filmesfavoritos.model.Filme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val dao = FilmeDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtDiretor = findViewById<EditText>(R.id.edt_diretor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabLista = findViewById<FloatingActionButton>(R.id.fab_lista)


        btnCadastrar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val diretor = edtDiretor.text.toString()

            val filme = Filme(titulo, diretor)

            dao.adicionarFilme(filme)

            Toast.makeText(this, "Filme Cadastrado", Toast.LENGTH_SHORT).show()

            edtTitulo.text.clear()
            edtDiretor.text.clear()
        }

        fabLista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

    }
}