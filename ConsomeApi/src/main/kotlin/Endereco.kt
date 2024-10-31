package org.aplicacao

import com.google.gson.annotations.SerializedName

class Endereco
    (@SerializedName("cep") val cep:String,
    @SerializedName("logradouro") val rua:String,
    @SerializedName("bairro") val bairro:String,
    @SerializedName("localidade") val cidade: String
    ){
    override fun toString(): String {
        return "Endereco(cep = $cep, rua = $rua, bairro = $bairro, cidade = $cidade)"
    }
}
