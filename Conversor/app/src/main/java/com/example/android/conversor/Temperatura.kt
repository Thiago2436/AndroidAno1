package com.example.android.conversor

class Temperatura(var celcius: Double, var fahrenheit: Double) {
    fun converterParaFahrenheit(celsius: Double): Double {
        return ((celsius * 9) / 5) + 32
    }

    fun converterParaCelsius(fahr: Double): Double {
        return ((fahr - 32) * 5 / 9)
    }
}