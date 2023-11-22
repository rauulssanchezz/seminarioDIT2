package com.example.seminariodit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

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



        correo=findViewById<TextInputEditText>(R.id.correo)
        contraseña=findViewById(R.id.contraseña)
        enviar=findViewById(R.id.button)
        nombre=findViewById(R.id.nombre)
        cp=findViewById(R.id.postal)
        edad=findViewById(R.id.nacimiento)

        correo.doAfterTextChanged { texto ->
            if (texto.isNullOrBlank()){
                correo.setError("El correo no puede estar vacio")
            }else if(!texto.contains("@gmail.com") && !texto.contains("@hotmail.com")){
                correo.setError("El correo no puede estar incompleto")
            }else{
                contraseña.isFocusable = true
                contraseña.requestFocus()
            }
        }

        contraseña.doAfterTextChanged{
            if(it.isNullOrBlank()){
                contraseña.setError("La contraseña no puede estar vacia")
            }else if(it.length<7){
                contraseña.setError("La contraseña debe tener mas de 7 caracteres")
            }else{
                val regex = Regex("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).*\$")
                if (!it.matches(regex)){
                    contraseña.setError("Debe contener al menos una letra minuscula, mayuscula y un numero")
                }else{
                    nombre.isFocusable=true
                    nombre.requestFocus()
                    cp.isFocusable=true
                }
            }
        }

        nombre.doAfterTextChanged {
            if (!it.isNullOrBlank()){
                cp.requestFocus()
            }else{
                nombre.setError("Este campo no puede quedar vacio")
            }
        }

        cp.doAfterTextChanged {
            if(it.isNullOrBlank()){
                edad.isFocusable=true
                edad.requestFocus()
            }else if(it.length==6){
                edad.isFocusable=true
                edad.requestFocus()
            }else{
                cp.setError("El codigo postal debe ser valido")
            }
        }


        }




    fun enviar(view: View) {

    }
}