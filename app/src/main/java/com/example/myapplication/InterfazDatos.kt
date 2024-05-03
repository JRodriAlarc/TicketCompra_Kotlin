package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InterfazDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Vincular los ID
        val producto: EditText = findViewById(R.id.editText_producto)
        val cantidad: EditText = findViewById(R.id.editText_cantidad)
        val precio: EditText = findViewById(R.id.editText_precio)
        val descuento: EditText = findViewById(R.id.editText_descuento)
        val btnCalcular: Button = findViewById(R.id.btn_calcular)

        //Cambiar de Interfaz
        btnCalcular.setOnClickListener{

            //Vifificacin de los Campos Llenos
            if (producto.text.isNotEmpty() && cantidad.text.isNotEmpty() && precio.text.isNotEmpty() && descuento.text.isNotEmpty()){

                val cambiarInterfaz = Intent(this, InterfazPago::class.java)

                cambiarInterfaz.putExtra("_producto", producto.text.toString())
                cambiarInterfaz.putExtra("_cantidad", cantidad.text.toString().toInt())
                cambiarInterfaz.putExtra("_precio", precio.text.toString().toDouble())
                cambiarInterfaz.putExtra("_descuento", descuento.text.toString().toInt())

                startActivity(cambiarInterfaz)

            } else {
                Toast.makeText(this, "Todos los Campos Deben Estar Llenos", Toast.LENGTH_SHORT).show()
            }

        }

    }

}