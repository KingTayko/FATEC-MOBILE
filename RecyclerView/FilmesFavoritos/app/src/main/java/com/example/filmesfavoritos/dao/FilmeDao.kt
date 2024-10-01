package com.example.filmesfavoritos.dao

import com.example.filmesfavoritos.model.Filme

interface FilmeDao {
    fun adicionarFilme(filme: Filme)
    fun obterFilme(): List<Filme>
}