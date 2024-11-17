package br.edu.medec.Modelview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.medec.R
import br.edu.medec.adapter.ConsultaListAdapter
import br.edu.medec.dao.Consultas
import com.google.firebase.firestore.FirebaseFirestore

class VisaoMedico : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var consultaList: MutableList<Consultas>
    private var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visao_medico)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        consultaList = mutableListOf()

        db.collection("Consulta").get().addOnSuccessListener { result ->
            if (!result.isEmpty) {
                for (data in result.documents) {
                    val consultas: Consultas? = data.toObject(Consultas::class.java)
                    if (consultas != null) {
                        consultaList.add(consultas)
                    }
                }
                recyclerView.adapter = ConsultaListAdapter(consultaList)
            } else {
                Toast.makeText(this, "Nenhuma consulta encontrada.", Toast.LENGTH_SHORT).show()
            }
        }
            .addOnFailureListener {
                Toast.makeText(this, "Erro ao carregar as consultas: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}