package com.example.cepapi.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cepapi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtCep = findViewById<EditText>(R.id.edt_cep)
        val btnSalvar = findViewById<Button>(R.id.btn_enviar)

        btnSalvar.setOnClickListener {
            if(edtCep.text.isEmpty()){
                Toast.makeText(this,"Dados insuficientes",Toast.LENGTH_SHORT).show()
            }else{

            }
        }

    }
}