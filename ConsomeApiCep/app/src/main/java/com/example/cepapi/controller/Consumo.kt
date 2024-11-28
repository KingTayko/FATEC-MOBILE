package com.example.cepapi.controller

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient


class Consumo {

    fun buscaEndereco(cep: Int): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://viacep.com.br/ws/$cep/json/"))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }
}
