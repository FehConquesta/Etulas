package com.example.etulas

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etulas.databinding.ActivityCadastroBinding
import com.example.etulas.databinding.ActivityDadosConvenioBinding

class DadosConvenio : AppCompatActivity() {

    private  lateinit var binding: ActivityDadosConvenioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDadosConvenioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btSalvar.setOnClickListener{
            val cadConv = findViewById<EditText>(R.id.cadConv).text.toString()
            val cadTipo = findViewById<EditText>(R.id.cadTipo).text.toString()
            val cadNum = findViewById<EditText>(R.id.cadNum).text.toString()


            if(cadConv.isEmpty()||cadTipo.isEmpty()||cadNum.isEmpty()){
                showAlert(
                    "OPS",
                    "Preencha todos os campos|"
                )
            }else{
                val navLogin = Intent(this, Login::class.java)
                startActivity(navLogin)
            }

        }


    }
    fun showAlert(title: String, message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK"){dialog, _ ->dialog.dismiss()}
        val dialog = builder.create()
        dialog.show()

    }
}