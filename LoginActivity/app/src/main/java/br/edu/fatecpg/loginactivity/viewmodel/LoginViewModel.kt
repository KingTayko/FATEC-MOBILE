package br.edu.fatecpg.loginactivity.viewmodel

import androidx.lifecycle.ViewModel
import br.edu.fatecpg.loginactivity.model.Admin
import br.edu.fatecpg.loginactivity.model.Usuario

class  LoginViewModel:ViewModel() {
    companion object{
        val usuarios = mutableListOf<Usuario>()
        val userBlocked = mutableListOf<String>()
    }

    private var contBlock = 0
    private val admin = Admin()

    fun cadastrar(Newuser: Usuario): String {
        val usuarioExistente = usuarios.find { it.login == Newuser.login }

        //usuario bloqueado
        if(userBlocked.contains(Newuser.login)){
            return "Cadastro não completado, Usuario Bloqueado!"
        }

        if (usuarioExistente != null) {
            return "Usuario ja cadastrado"
        } else {
            usuarios.add(Newuser)
            return "Usuario Cadastrado com sucesso!"
        }



    }


    fun logar(user: Usuario): String {

        val usuarioExistente = usuarios.find { it.login == user.login }

        if (userBlocked.contains(user.login)){
            return "Erro de login, Usuario Bloqueado"
        }

        if (usuarioExistente != null) {
            if (usuarioExistente.senha == user.senha) {
                contBlock = 0
                return "Login realizado com sucesso!"
            } else {
                contBlock++
                if (contBlock >= 3) {
                    userBlocked.add(user.login)
                    usuarios.remove(usuarioExistente)
                    contBlock = 0
                    return "Usuário Bloqueado!"
                }
                return "Login recusado!"
            }
        } else {
            return "Usuário não cadastrado"
        }
    }



    fun logarAdmin(admin: Admin): String {
        //verificando se a senha e o login do admin é o mesmo do dataClass
        if (this.admin.login == admin.login && this.admin.senha == admin.senha)  {
            return "Administrador logado"
        } else {
            return "login recusado"
        }
    }
    //criar uma funçao de retorno de usuarios
    fun retUsuarios():MutableList<Usuario>{
        return usuarios
    }
}