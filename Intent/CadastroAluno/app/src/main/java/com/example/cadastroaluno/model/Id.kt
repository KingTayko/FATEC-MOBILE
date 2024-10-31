package com.example.cadastroaluno.model

import kotlin.random.Random

class Id {
    companion object {
        fun gerarNumerosAleatorios(
            quantidade: Int,
            intervalo: IntRange
        ): List<Int> {//criação da função de geração do id e criação da lista
            return List(quantidade) {
                Random.nextInt(
                    intervalo.first,
                    intervalo.last + 1
                )  //parametros da lista, com numeros aleatorios
            }
        }
    }
}

