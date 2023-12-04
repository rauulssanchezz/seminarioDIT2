package com.example.seminariodit2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun boton(view: View) {
        var nombre = findViewById<TextInputEditText>(R.id.nombre)
        var nombre2 = nombre.text ?: ""
        var niños = findViewById<TextInputEditText>(R.id.niños)
        var niños2 = niños.text.toString() ?: ""
        if(nombre2.length<2){
            nombre.error="Escribe un nombre correcto"
        }else if (nombre2.isEmpty()){
            nombre.error="No se puede dejar el nombre en blanco"
        }else if (niños2.toInt() !=0){
            niños.error = "Que turbio bro"
        }else{
            recreate()
        }

    }
}

