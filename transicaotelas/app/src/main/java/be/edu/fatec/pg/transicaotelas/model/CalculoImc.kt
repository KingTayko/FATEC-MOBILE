package be.edu.fatec.pg.transicaotelas.model

class CalculoImc {
    fun calcula(peso: Double, altura: Double): Double{
        val imc = peso / (altura * altura)
        return imc

    }
}