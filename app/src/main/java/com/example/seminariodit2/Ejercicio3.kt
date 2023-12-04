package com.example.seminariodit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Ejercicio3 : AppCompatActivity() {

    lateinit var correo:TextInputEditText
    lateinit var contraseña:TextInputEditText
    lateinit var enviar:Button
    lateinit var nombre:TextInputEditText
    lateinit var cp:TextInputEditText
    lateinit var edad:TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)
        correo = findViewById(R.id.correo)
        contraseña = findViewById(R.id.contraseña)
        nombre = findViewById(R.id.nombre)
        cp= findViewById(R.id.postal)
        edad= findViewById(R.id.nacimiento)




        correo.addTextChangedListener {
            if (it.isNullOrBlank() || !it.contains("@") || !it.contains(".")) {
                correo.error = "Correo no completado con exito"
            }
        }

        contraseña.addTextChangedListener {
            println(it)
            if (it != null) {
                if (it.length < 7) {
                    contraseña.error = "La contraseña es demasiado corta"
                }
                val regex = Regex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).+\$")

                if (it.matches(regex)) {
                    println("entra")

                } else {
                    contraseña.error =
                        ("La contraseña debe contener mayusc. minusc. y numeros ")
                }
            } else {
                contraseña.error = "La contraseña no puede estar vacia"
            }


        }
        nombre.addTextChangedListener{
            if(it.isNullOrBlank()){
                nombre.error="Esque no tienes nombre? Gilipollas"

            }
        }

        cp.addTextChangedListener {
            if (it.toString().length < 5 && it.toString().length>0) {
                cp.error = "El CP es incorrecto"
            }
        }

        fun isAdult(dateOfBirth: String): Boolean {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val currentDate = Calendar.getInstance().time

            try {
                val birthDate = dateFormat.parse(dateOfBirth)
                val calendarBirth = Calendar.getInstance().apply {
                    time = birthDate
                }

                val age = Calendar.getInstance().get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR)

                calendarBirth.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR))

                return if (calendarBirth.time.before(currentDate)) {
                    age >= 18
                } else {
                    age - 1 >= 18
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
        }

        edad.addTextChangedListener {
            if (!isAdult(it.toString())) {
                edad.error="Debes ser mayor de edad"
            }else{

            }
        }
    }


}