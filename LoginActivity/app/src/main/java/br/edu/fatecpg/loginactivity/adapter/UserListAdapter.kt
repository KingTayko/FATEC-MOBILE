package br.edu.fatecpg.loginactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.loginactivity.R
import br.edu.fatecpg.loginactivity.model.Usuario



class UserListAdapter(val usuarios: MutableList<Usuario>) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.txt_login)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user_list, parent, false)

        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = usuarios[position]
        holder.textView.setText(user.login)
    }
}