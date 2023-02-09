package com.example.aplicativoreceitas

object ReceitasBO {
    fun validateLogin(aUsuario: String, aSenha: String){
        if (aUsuario.isNullOrEmpty()) throw Exception("Campo usuário está vazio!")
        if (aSenha.isNullOrEmpty()) throw Exception("Campo senha está incorreto!")

    }
}