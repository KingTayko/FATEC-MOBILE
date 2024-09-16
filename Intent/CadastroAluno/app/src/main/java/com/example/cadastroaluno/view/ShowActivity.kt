package com.example.cadastroaluno.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastroaluno.R

class ShowActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_activity)

        val bundle = intent.extras
        val aluno = bundle?.getString("Aluno")
        val id = bundle?.getString("Id")

        val txvAluno = findViewById<TextView>(R.id.txv_aluno)
        val txvId = findViewById<TextView>(R.id.txv_id)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)

        if(aluno.toString().isEmpty() || id.toString().isEmpty()){
            Toast.makeText(this,"Aluno não encontrado",Toast.LENGTH_SHORT).show()
        }else{
            txvAluno.text = aluno
            txvId.text = id
        }

        btnVoltar.setOnClickListener {
            finish()
        }

    }
}