package br.edu.fatecpg.loginactivity.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.loginactivity.R
import br.edu.fatecpg.loginactivity.databinding.ActivityLoginBinding
import br.edu.fatecpg.loginactivity.model.Usuario
import br.edu.fatecpg.loginactivity.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    // da pra fazer tambem
    //private val viewModel:LoginViewModel()
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogar.setOnClickListener {
            val login = binding.edtLogin.text.toString()
            val senha = binding.edtSenha.text.toString()
            val user = Usuario(login,senha)
            val retorno = viewModel.logar(user)
            if(retorno=="Login realizado com sucesso!") {
                Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()

                binding.edtLogin.setText("")
                binding.edtSenha.setText("")
            }
            else{
                Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
            }

        //logar
        }
        binding.btnCadastrar.setOnClickListener {
            val login = binding.edtLogin.text.toString()
            val senha = binding.edtSenha.text.toString()
            val user = Usuario(login,senha)
            val retorno = viewModel.cadastrar(user)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
            //cadastrar
        }

        binding.fabAdmin.setOnClickListener {
            val intent = Intent(this,LoginAdmin::class.java)
            startActivity(intent)
        }
    }
}