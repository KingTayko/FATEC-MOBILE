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
import br.edu.fatecpg.loginactivity.databinding.ActivityAdminBinding
import br.edu.fatecpg.loginactivity.databinding.ActivityLoginBinding
import br.edu.fatecpg.loginactivity.model.Admin
import br.edu.fatecpg.loginactivity.model.Usuario
import br.edu.fatecpg.loginactivity.viewmodel.LoginViewModel

class LoginAdmin : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogar.setOnClickListener {
            val login = binding.edtLogin.text.toString()
            val senha = binding.edtSenha.text.toString()
            val admin = Admin(login, senha)
            val administrador = viewModel.logarAdmin(admin)
            //mensagem de texto



            // Verifica se o login foi bem-sucedido
            if (administrador == "Administrador logado") {
                // Exibe uma mensagem de sucesso e abre a nova Activity
                Toast.makeText(this, administrador, Toast.LENGTH_SHORT).show()

                // Limpando os campos
                binding.edtLogin.setText("")
                binding.edtSenha.setText("")

                // Aciona o Intent para a RecyclerView
                val rv = Intent(this, RecyclerView::class.java)
                startActivity(rv)
            } else {
                // Exibe mensagem de erro se o login falhar
                Toast.makeText(this, administrador, Toast.LENGTH_SHORT).show()
            }
        }
    }
}