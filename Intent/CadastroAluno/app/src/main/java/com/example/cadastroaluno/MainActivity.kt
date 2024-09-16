package com.example.cadastroaluno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastroaluno.model.Id
import com.example.cadastroaluno.view.ShowActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val edtNome =  findViewById<EditText>(R.id.edt_nome)
        val btnCad = findViewById<Button>(R.id.btn_cadastrar)


        btnCad.setOnClickListener {
            if(edtNome.text.isEmpty()){
                Toast.makeText(this,"Dados insuficientes",Toast.LENGTH_SHORT).show()
            }
            else{
                val aluno = edtNome.text.toString()
                val bundle = Bundle()


                bundle.putString("Aluno", aluno)

                // Chama a função para gerar números aleatórios
                val numerosAleatorios = Id.gerarNumerosAleatorios(10,1..10)// Chama a função diretamente pela classe
                println(numerosAleatorios.joinToString(separator = ""))//eliminando o espaçamento

                bundle.putString("Id", numerosAleatorios.joinToString(separator = ""))
                val intent = Intent(this, ShowActivity::class.java)
                intent.putExtras(bundle)

                startActivity(intent)

            }
        }

    }
}