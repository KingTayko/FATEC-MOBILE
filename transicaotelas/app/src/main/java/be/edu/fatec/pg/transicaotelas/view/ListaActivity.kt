package be.edu.fatec.pg.transicaotelas.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import be.edu.fatec.pg.transicaotelas.R
import be.edu.fatec.pg.transicaotelas.dao.PessoaDao
import be.edu.fatec.pg.transicaotelas.model.Pessoa
import be.edu.fatec.pg.transicaotelas.model.CalculoImc
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity() {
    val dao = PessoaDao()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        //txv_nome, txv_whats, fab_volta
        val txvmensag = findViewById<TextView>(R.id.txv_mensagem)
        val txvResult = findViewById<TextView>(R.id.txv_resultado)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)




        //trazendo a conta
        val pessoa: Pessoa = dao.exibirContato();
        txvmensag.text = pessoa.mensagem
        txvResult.text = pessoa.resul.toString()

        fabVolta.setOnClickListener{
            finish()
        }

    }
}