package br.edu.medec.Modelview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.medec.databinding.ActivityBdPacienteBinding
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class BD_paciente : AppCompatActivity() {
    private lateinit var binding: ActivityBdPacienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBdPacienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = FirebaseFirestore.getInstance() // Usando a instância do Firestore


        binding.btnSalvar.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val idade = binding.edtIdade.text.toString().toIntOrNull() ?: 0 // Tratando caso de idade inválida
            val dataStr = binding.etdData.text.toString() // Data digitada pelo usuário
            val horaStr = binding.etdHora.text.toString() // Hora digitada pelo usuário

            // Validações para garantir que os campos não estejam vazios
            if (nome.isEmpty()) {
                Toast.makeText(this, "Por favor, insira o nome.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (idade <= 0) {
                Toast.makeText(this, "Por favor, insira uma idade válida.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (dataStr.isEmpty()) {
                Toast.makeText(this, "Por favor, insira uma data válida.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (horaStr.isEmpty()) {
                Toast.makeText(this, "Por favor, insira uma hora válida.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Convertendo a string da data para o formato Date
            val formatoData = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) // Formato de data: dd/MM/yyyy
            val formatoHora = SimpleDateFormat("HH:mm", Locale.getDefault()) // Formato de hora: HH:mm

            // Ajuste do formato da data para aceitar entrada sem barras
            val dataStrFormatado = if (dataStr.length == 8) {
                "${dataStr.substring(0, 2)}/${dataStr.substring(2, 4)}/${dataStr.substring(4)}"
            } else {
                dataStr
            }

            val data = try {
                formatoData.parse(dataStrFormatado) // Convertendo a string da data para Date
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

            val hora = try {
                formatoHora.parse(horaStr) // Convertendo a string da hora para Date
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

            if (data == null || hora == null) {
                Toast.makeText(this, "Data ou hora inválida. Por favor, verifique os formatos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Combinando a data com a hora
            val calendar = Calendar.getInstance()
            calendar.time = data // Atribuindo a data
            val calendarHora = Calendar.getInstance()
            calendarHora.time = hora // Atribuindo a hora
            calendar.set(Calendar.HOUR_OF_DAY, calendarHora.get(Calendar.HOUR_OF_DAY))
            calendar.set(Calendar.MINUTE, calendarHora.get(Calendar.MINUTE))

            val timestamp = Timestamp(calendar.time) // Convertendo a data combinada em Timestamp

            // Conectando as variáveis ao banco de dados
            val paciente = hashMapOf(
                "nome" to nome,
                "idade" to idade,
                "data" to timestamp // Salvando o timestamp combinado (data + hora)
            )

            // Adicionando os dados à coleção 'Consulta'
            db.collection("Consulta")
                .add(paciente)
                .addOnSuccessListener {
                    Toast.makeText(this, "Consulta salva com sucesso.", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Falha ao salvar consulta.", Toast.LENGTH_SHORT).show()
                }


            binding.edtNome.text.clear()
            binding.edtIdade.text.clear()
            binding.etdData.text.clear()
            binding.etdHora.text.clear()
        }
    }
}
