package com.example.seminariodit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
    }
    fun boton(view: View) {
        val usuario = findViewById<TextInputEditText>(R.id.layoutUsuarioText)
        val usuario2 = usuario.text ?: ""
        val contrasena = findViewById<TextInputEditText>(R.id.layoutContrasenaText)
        val gmail = findViewById<TextInputEditText>(R.id.layoutEmailText)
        val gmail2 = gmail.text ?: ""


        if (usuario2.isEmpty()) {
            usuario.error = "Error al introducir usuario"
        } else if (contrasena.length() < 6) {
            contrasena.error = "Contraseña incorrecta."
        } else if (!gmail2.contains("@") && !gmail2.contains(".")) {
            gmail.error = "Correo electronico no valido."
        }
    }
}