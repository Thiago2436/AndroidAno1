package com.example.dividirconta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener { calcularConta() }
    }

    fun calcularConta() {
        val edtValorConta = findViewById<EditText>(R.id.edtValorConta)
        val edtQtdPessoas = findViewById<EditText>(R.id.edtQtdPessoas)
        val edtServico = findViewById<EditText>(R.id.edtServico)

        val strValorDaConta = edtValorConta.text.toString()
        val strQtdPessoas = edtQtdPessoas.text.toString()
        val strServico = edtServico.text.toString()

        if (strValorDaConta.isNullOrEmpty() || strQtdPessoas.isNullOrEmpty() || strServico.isNullOrEmpty()) {
            Toast.makeText(this, "Favor fornecer valores para todos os campos.", Toast.LENGTH_LONG).show()
            return
        }

        var valorDaConta = strValorDaConta.toDouble()
        var qtdPessoas = strQtdPessoas.toInt()
        var servico = strServico.toDouble()

        var conta = Conta(valorDaConta, servico, qtdPessoas)

        val txtValorPessoa = findViewById<TextView>(R.id.txtValorPessoa)
        val txtServicoPessoa = findViewById<TextView>(R.id.txtServicoPessoa)
        val txtTotalPessoa = findViewById<TextView>(R.id.txtTotalPessoa)

        txtValorPessoa.text = "Conta/Pessoa: R$ ${conta.calcularValorPorPessoa()}"
        txtServicoPessoa.text = "Serviço/Pessoa: R$ ${conta.calcularServicoPorPessoa()}"
        txtTotalPessoa.text = "Total/Pessoa: R$ ${conta.calcularServicoPorPessoa() + conta.calcularValorPorPessoa()}"
    }
}