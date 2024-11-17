package br.edu.medec.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.medec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.btnMedico.setOnClickListener {

            val intent = Intent(this, Medico::class.java)
            startActivity(intent)

        }

        binding.btnPaciente.setOnClickListener {
            val intent = Intent(this, Paciente::class.java)
            startActivity(intent)


        }




    }
}