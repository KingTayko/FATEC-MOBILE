package br.edu.fatecpg.dao

import androidx.room.Dao
<<<<<<< HEAD
=======
import androidx.room.Delete
>>>>>>> 58d02d6c22c80fb915b6621bdd1bb4c97ba2cc55
import androidx.room.Insert
import androidx.room.Query
import br.edu.fatecpg.model.User

@Dao
interface UserDao {
    //@Query e um comando que serve para que voce possa utilizar comandos de "busca" do sql no kotlin
    @Query("SELECT * FROM user")
    fun getAll():List<User>

    //Comando de insercao de dados
    //vararg serve para que voce possa passsar quantos dados quiser sem precisar especificar a quantidade de elementos
    @Insert
    suspend fun insertAll(vararg user: User)

<<<<<<< HEAD
=======

>>>>>>> 58d02d6c22c80fb915b6621bdd1bb4c97ba2cc55
}