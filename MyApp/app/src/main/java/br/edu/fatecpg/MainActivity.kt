package br.edu.fatecpg

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth




        binding.btnLogin.setOnClickListener{

            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()


            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this){
                        task -> if(task.isSuccessful){
                    Toast.makeText(this,"Sucesso",Toast.LENGTH_SHORT).show()

                    val user = Firebase.auth.currentUser!!
                    user.delete()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "User account deleted.")
                                Toast.makeText(baseContext,"Conta Deletada",Toast.LENGTH_SHORT).show()
                            }
                        }
                }else{
                    Toast.makeText(this,"Erro!",Toast.LENGTH_SHORT).show()
                }

                }
        }

        binding.txvCadastro.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()

            auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()


                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Falha na autentificacao",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }
        }

        //metodo de enviar um email de redefinicao de senha
        binding.txvRvsenha.setOnClickListener{
            val email = binding.edtEmail.text.toString()

            Firebase.auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Email enviado.")
                        Toast.makeText(this,"Email enviado",Toast.LENGTH_SHORT).show()
                    }
                }
        }



    }
}
