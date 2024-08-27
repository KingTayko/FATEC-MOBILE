package com.example.calculadoraohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraohm.controller.Calc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val calcResistencia = findViewById<Button>(R.id.btnCalcResistencia)
        val calcCorrente = findViewById<Button>(R.id.btnCalcCorrente)
        val calcTensao = findViewById<Button>(R.id.btnCalcTensao)
        val calcResultado = findViewById<Button>(R.id.btnCalcResultado)

        val textValor1 = findViewById<EditText>(R.id.edtPrimeiroNumero)
        val textValor2 = findViewById<EditText>(R.id.edtSegundoNumero)
        val textResp = findViewById<TextView>(R.id.txtResp)

        var valor1 = 0.0
        var valor2 = 0.0
        var resultado = 0.0
        var optCalc = 0

        val calcula = Calc()


        calcResistencia.setOnClickListener(){
            textValor1.hint="Digite a tensão (V)"
            textValor2.hint="Digite a corrente (I)"

            optCalc = 1
        }

        calcCorrente.setOnClickListener(){
            textValor1.hint="Digite a tensão (V)"
            textValor2.hint="Digite a resistência (R)"

            optCalc = 2
        }

        calcTensao.setOnClickListener(){
            textValor1.hint="Digite a resistência (R)"
            textValor2.hint="Digite a corrente (I)"

            optCalc = 3
        }

        calcResultado.setOnClickListener(){

            if (textValor1.text.toString().isEmpty() || textValor2.text.isEmpty()){
                Toast.makeText(this, "Preencha os valores corretamente!", Toast.LENGTH_SHORT).show()
            } else {
                valor1 = textValor1.text.toString().toDouble()
                valor2 = textValor2.text.toString().toDouble()
            }

            when (optCalc){
                1 -> {
                    resultado = calcula.resistencia(valor1, valor2)
                    textResp.text = "Resistência: $resultado Ohms"
                }
                2 -> {
                    resultado = calcula.corrente(valor1, valor2)
                    textResp.text = "Corrente: $resultado A"
                }
                3 -> {
                    resultado = calcula.tensao(valor1, valor2)
                    textResp.text = "Tensão: $resultado V"
                }
                else -> {
                    Toast.makeText(this, "Selecione uma das opções!", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }
}