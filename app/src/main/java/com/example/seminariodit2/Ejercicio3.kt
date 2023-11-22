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
        var bolcorreo=false
        var bolcontraseña=false
        var bolcp=false
        var boledad=false


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
                bolcorreo=true
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
                    bolcontraseña=true
                }
            }
        }



        cp.doAfterTextChanged {
            if(it.isNullOrBlank()){
                bolcp=true
            }else if(it.length==5){
                bolcp=true
            }else{
                cp.setError("El codigo postal debe ser valido")
            }
        }


        edad.after {
            if(it.isNullOrBlank()){
                edad.setError("Este campo no puede quedar vacio")
            }else{

                var split=it.split("/")
                var año=split[2].toInt()
                if(Calendar.YEAR-año>=18){
                    boledad=true
                }else{
                    edad.setError("Debes ser mayor de edad")
                }
            }
        }

        }




    fun enviar(view: View) {

    }
}