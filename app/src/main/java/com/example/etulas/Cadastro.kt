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
import com.example.etulas.databinding.ActivityLoginBinding

class Cadastro : AppCompatActivity() {

    private  lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btAvancar.setOnClickListener{

            val nome = findViewById<EditText>(R.id.cadNome).text.toString()
            val email = findViewById<EditText>(R.id.cadEmail).text.toString()
            val senha = findViewById<EditText>(R.id.cadSenha).text.toString()
            val confSenha = findViewById<EditText>(R.id.cadConfSenha).text.toString()


            if(nome.isEmpty()||email.isEmpty()||senha.isEmpty()||confSenha.isEmpty()){
                showAlert(
                    "OPS!!!",
                    "Preencha todos os campos"
                )
            }else if(senha != confSenha){
                showAlert(
                    "OPS!!",
                    "As senhas não correspondem!"
                )
            }else{
                val navConv = Intent(this, DadosConvenio::class.java)
                startActivity(navConv)
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