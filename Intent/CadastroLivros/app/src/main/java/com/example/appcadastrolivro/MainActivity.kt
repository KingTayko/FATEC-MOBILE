package com.example.appcadastrolivro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcadastrolivro.view.ShowActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val edtLivro = findViewById<EditText>(R.id.edt_livro)
        val edtAutor = findViewById<EditText>(R.id.edt_autor)
        val btnSalvar  = findViewById<Button>(R.id.btn_salvar)


        btnSalvar.setOnClickListener{
            if(edtLivro.text.toString().isEmpty() || edtAutor.text.toString().isEmpty()){
                Toast.makeText(this,"Dados Insuficientes", Toast.LENGTH_SHORT).show()
            }else{
                val livro = edtLivro.text.toString()
                val autor = edtAutor.text.toString()

                val bundle = Bundle()
                val intent = Intent(this, ShowActivity::class.java)
                bundle.putString("Livro", livro)
                bundle.putString("Autor", autor)
                intent.putExtras(bundle)

                startActivity(intent)

                edtLivro.text.clear()
                edtAutor.text.clear()

            }
        }



    }
}