package com.example.filmesfavoritos.dao

import com.example.filmesfavoritos.model.Filme

class FilmeDaoImpl:FilmeDao {

    companion object{
        private val filmes = mutableListOf<Filme>()
    }

    override fun adicionarFilme(filme: Filme) {
        Companion.filmes.add(filme)
    }

    override fun obterFilme(): List<Filme>{
        return Companion.filmes
    }

}