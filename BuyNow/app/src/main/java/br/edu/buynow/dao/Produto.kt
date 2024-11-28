package br.edu.buynow.dao

data class Produto(
    val nome:String,
    val categoria:String,
    val preco:Double = 0.0
)
