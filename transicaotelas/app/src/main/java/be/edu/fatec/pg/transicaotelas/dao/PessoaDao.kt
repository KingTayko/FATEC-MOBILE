package be.edu.fatec.pg.transicaotelas.dao

import be.edu.fatec.pg.transicaotelas.model.Pessoa

class PessoaDao {
    companion object{
    private var imcPessoa: Pessoa? = null
    }

    fun cadastroContato(contato:Pessoa){
    Companion.imcPessoa = contato

    }
    fun exibirContato():Pessoa{
        return Companion.imcPessoa?:Pessoa()
    }
}