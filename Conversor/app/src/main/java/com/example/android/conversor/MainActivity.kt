package com.example.android.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
/*THIAGO MARTINS E RENATA SALVARANI.*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnConverter = findViewById<Button>(R.id.buttonConverter)

        btnConverter.setOnClickListener { converter() }
        }
/* CHAMA A CLASSE E OS PAREMETROS*/
        fun converter() {
             val edtCelsius = findViewById<EditText>(R.id.editTextCelsius)
             val edtFahrenheit = findViewById<EditText>(R.id.editTextFahrenheit)

            val doubleCelsius = edtCelsius.text.toString()
            val doubleFahrenheit = edtFahrenheit.text.toString()
/* VALIDA SE OS CAMPOS ESTAO PREECHIDOS*/
        if(doubleCelsius.isNullOrEmpty() && doubleFahrenheit.isNullOrEmpty()) {
            Toast.makeText(getApplicationContext(),
                "INFORMAR VALOR",
                Toast.LENGTH_LONG).show();
        }

        if(!doubleCelsius.isNullOrEmpty()) {
            val doubleCelsius = edtCelsius.text.toString().toDouble()
            /* RESETA FAHRENHEIT*/
            var doubleFah = 0.0

            var temperatura = Temperatura(doubleCelsius, doubleFah)

            val resultado = temperatura.converterParaFahrenheit(doubleCelsius)

            edtFahrenheit.setText(resultado.toString().format(2))
        }

        if(!doubleFahrenheit.isNullOrEmpty()) {
            val doubleCelsius = 0.0
            var doubleFah = edtFahrenheit.text.toString().toDouble()

            var temperatura = Temperatura(doubleCelsius, doubleFah)

            val resultado = temperatura.converterParaCelsius(doubleFah)

            edtCelsius.setText(resultado.toString().format(2))
        }
    }
    }
