package com.example.etulas

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etulas.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login =findViewById<EditText>(R.id.loginTxt)
        val password = findViewById<EditText>(R.id.senhaTxt)

        binding.btEntrar.setOnClickListener{
            val nome = login.text.toString()
            val senha = password.text.toString()

            if(nome.isEmpty() || senha.isEmpty()) {
                showAlert(
                    "OPS!!!",
                    "Preencha todos os campos"
                )

            }
            else {
                val navMaps = Intent(this, Maps::class.java)
                startActivity(navMaps)
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