package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val num1  = findViewById(R.id.editTextText2) as EditText
        val num2  = findViewById(R.id.editTextText) as EditText
        val tot  = findViewById(R.id.editTextText3) as EditText
        val soma = findViewById(R.id.button) as Button
        val sub = findViewById(R.id.button3) as Button
        val mult = findViewById(R.id.button5) as Button
        val divi = findViewById(R.id.button4) as Button



        soma.setOnClickListener {
            if(num1.text.toString().isEmpty() || num2.text.toString().isEmpty()){
                Toast.makeText(this,"Esta faltando um numero", Toast.LENGTH_SHORT).show()
            }else {
                val val1 = num1.text.toString().toFloat();
                val val2 = num2.text.toString().toFloat();

                val result = val1 + val2

                tot.setText(result.toString())
            }
        }

        sub.setOnClickListener {
            if(num1.text.toString().isEmpty() || num2.text.toString().isEmpty()){
                Toast.makeText(this,"Esta faltando um numero", Toast.LENGTH_SHORT).show()
            }else {
                val val1 = num1.text.toString().toFloat();
                val val2 = num2.text.toString().toFloat();

                val result = val1 - val2

                tot.setText(result.toString())
            }
        }

        mult.setOnClickListener {
            if(num1.text.toString().isEmpty() || num2.text.toString().isEmpty()){
                Toast.makeText(this,"Esta faltando um numero", Toast.LENGTH_SHORT).show()
            }else {
                val val1 = num1.text.toString().toFloat();
                val val2 = num2.text.toString().toFloat();

                val result = val1 * val2

                tot.setText(result.toString())
            }
        }

        divi.setOnClickListener {
            if(num1.text.toString().isEmpty() || num2.text.toString().isEmpty()){
                Toast.makeText(this,"Esta faltando um numero", Toast.LENGTH_SHORT).show()
            }else {
                val val1 = num1.text.toString().toFloat();
                val val2 = num2.text.toString().toFloat();

                val result = val1 / val2

                tot.setText(result.toString())
            }
        }
    }
}