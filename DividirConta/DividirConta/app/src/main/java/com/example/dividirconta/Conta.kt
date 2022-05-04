package com.example.dividirconta

class Conta(var valor: Double, var taxaDeServico: Double, var pessoas: Int) {

    fun calcularValorPorPessoa(): Double {
        return valor / pessoas
    }

    fun calcularServicoPorPessoa(): Double {
        return (valor * taxaDeServico / 100) / pessoas
    }
}