package br.edu.medec.view

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.medec.Modelview.VisaoMedico
import br.edu.medec.databinding.ActivityMedicoBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Medico : AppCompatActivity() {
    private lateinit var binding: ActivityMedicoBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMedicoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth




        binding.btnLogin.setOnClickListener{

            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()


            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this){
                        task -> if(task.isSuccessful){
                    Toast.makeText(this,"Sucesso",Toast.LENGTH_SHORT).show()


                    //verificando o usuario
                    val user = Firebase.auth.currentUser!!
                    //transferindo para o recyclerView
                    val view_med = Intent(this, VisaoMedico::class.java)
                    startActivity(view_med)
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
    }
}