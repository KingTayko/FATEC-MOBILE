package be.edu.fatec.pg.transicaotelas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import be.edu.fatec.pg.transicaotelas.R
import be.edu.fatec.pg.transicaotelas.dao.PessoaDao
import be.edu.fatec.pg.transicaotelas.model.Pessoa
import be.edu.fatec.pg.transicaotelas.model.CalculoImc

class CadastroActivity : AppCompatActivity() {
    val dao = PessoaDao()
    val imc = CalculoImc()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        //edt_peso, edt_altura, btnCalcular
        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val edtAltura = findViewById<EditText>(R.id.edt_altura)
        val btnCalcula = findViewById<Button>(R.id.btnCalcular)
        var msg = ""

        btnCalcula.setOnClickListener{
                if(edtPeso.text.toString().isEmpty() || edtAltura.text.toString().isEmpty()){
                    Toast.makeText(this,"Insira todos os dados", Toast.LENGTH_SHORT).show()
                }else {
                    val peso = edtPeso.text.toString().toDouble()
                    val altura = edtAltura.text.toString().toDouble()

                    val resul = imc.calcula(peso, altura)
                    if (resul < 18.5) {
                        msg = "Baixo Peso";
                    } else if (resul > 18.5 && resul < 24.99) {
                        msg = "Normal";
                    } else if (resul > 25 && resul < 29.99) {
                        msg = "Sobrepeso";
                    } else {
                        msg = "Obesidade";
                    }


                    val pessoa = Pessoa(peso, altura, msg, resul)
                    dao.cadastroContato(pessoa)
                    val intent = Intent(this, ListaActivity::class.java)
                    startActivity(intent)

                    //Toast.makeText(this,"Cadastro Realizado com Sucesso",Toast.LENGTH_SHORT).show()
                    edtPeso.text.clear()
                    edtAltura.text.clear()
                }
        }


    }
}