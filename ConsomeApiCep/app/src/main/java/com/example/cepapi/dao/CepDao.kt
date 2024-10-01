package com.example.cepapi.dao

import com.example.cepapi.model.Endereco

class CepDao {
        companion object{
            private var endereco:Endereco? = null
        }
    fun ExibirEndereco(): Endereco {
        return endereco?:Endereco()
    }


}