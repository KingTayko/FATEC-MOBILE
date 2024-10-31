package br.edu.fatecpg.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import br.edu.fatecpg.R
import br.edu.fatecpg.dao.UserDao
import br.edu.fatecpg.database.AppDatabase
import br.edu.fatecpg.databinding.ActivityMainBinding
import br.edu.fatecpg.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //construcao do banco de dados
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-app"
        ).fallbackToDestructiveMigration()
            .build()

        //esse comando da ao banco de dados acesso as funcoes contidas dentro do dao(exp: a funcao @Query("SELECT * FROM user") fun getAll():List<User>) )
        userDao = db.userDao()

        binding.btnSalvar.setOnClickListener {
            val nome = binding.edtFirstName.text.toString()
            val sobrenome = binding.edtLastName.text.toString()
            val user = User(0, nome, sobrenome)

            //LifecycleScope serve para fazer o processo a parte do processo principal
            lifecycleScope.launch {
                userDao.insertAll(user)
            }
            binding.edtFirstName.setText("")
            binding.edtLastName.setText("")

            Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
        }


        binding.btnListar.setOnClickListener {
            lifecycleScope.launch {
                //a linha de baixo e feita para que os dados da lista sejam mostrados no logcat
                val list = withContext(Dispatchers.IO) {
                    userDao.getAll()
                }
                list.forEach{
                    Log.d("USUARIO", (it.uid).toString() + " - "
                            + it.firstName + " - "
                            + it.lastName
                    )
                }
            }
        }
    }
}