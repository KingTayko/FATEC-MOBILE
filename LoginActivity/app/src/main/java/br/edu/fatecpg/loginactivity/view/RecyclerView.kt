package br.edu.fatecpg.loginactivity.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.fatecpg.loginactivity.adapter.UserListAdapter
import br.edu.fatecpg.loginactivity.databinding.ActivityRecyclerViewBinding
import br.edu.fatecpg.loginactivity.model.Usuario
import br.edu.fatecpg.loginactivity.viewmodel.LoginViewModel


class RecyclerView : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        //Instancia pela classe aonde esta sendo obtido os dados
         val viewModel = LoginViewModel()
        binding.recyclerView.adapter = UserListAdapter(viewModel.retUsuarios())

    }
}