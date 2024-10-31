package com.example.filmesfavoritos.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmesfavoritos.R
import com.example.filmesfavoritos.adapter.FilmeAdapter
import com.example.filmesfavoritos.dao.FilmeDaoImpl

class ListaActivity : AppCompatActivity() {

    val dao = FilmeDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        Log.i("FILME", dao.obterFilme().toString())

        val rvFilmes = findViewById<RecyclerView>(R.id.rv_filmes)
        val filmes = dao.obterFilme()

        rvFilmes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvFilmes.adapter = FilmeAdapter(filmes)

    }
}