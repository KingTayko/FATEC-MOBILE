package org.aplicacao

import com.google.gson.Gson
import java.util.*

fun main(args: Array<String>) {
    val ler = Scanner(System.`in`)
    val consumo = Consumo()
    val gson = Gson()

    print("Digite o  cep  que deseja buscar: ")
    val cep = ler.nextInt()

    val json = consumo.buscaEndereco(cep)
    println(json)

    val endereco = gson.fromJson(json, Endereco::class.java)
    println(endereco.rua)

}