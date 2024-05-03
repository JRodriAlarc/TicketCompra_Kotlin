package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InterfazPago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_pago)

        //Vincular los ID
        val btnRegresar: Button = findViewById(R.id.btn_regresar)

        val txtProducto: TextView = findViewById(R.id.txt_result_producto)
        val txtCantidad: TextView = findViewById(R.id.txt_result_cantidad)
        val txtPrecioUnit: TextView = findViewById(R.id.txt_result_precio_unidad)
        val txtDescuento: TextView = findViewById(R.id.txt_result_descuento)
        val txtTotal: TextView = findViewById(R.id.txt_result_total)
        val txtSubtotal: TextView = findViewById(R.id.txt_result_subtotal)

        //Recibir los Datos
        val datosInterfaz1 = intent.extras

        //Obtener los Datos de la Interfaz1
        val productoCliente = datosInterfaz1?.getString("_producto")
        val cantidadCliente = datosInterfaz1?.getInt("_cantidad")
        val precioUnitCliente = datosInterfaz1?.getDouble("_precio")
        val descuentoCliente = datosInterfaz1?.getInt("_descuento")

        //Calcular el Subtotal y Total
        val subtotalCliente = cantidadCliente.toString().toInt() * precioUnitCliente.toString().toDouble()
        val descuentoProducto = ((subtotalCliente * descuentoCliente.toString().toDouble()) / 100)
        val totalCliente = subtotalCliente - descuentoProducto


        //Mostrar los Datos en esta Interfaz
        txtProducto.text = productoCliente
        txtCantidad.text = cantidadCliente.toString()
        txtPrecioUnit.text = precioUnitCliente.toString()
        txtDescuento.text = descuentoCliente.toString()
        txtSubtotal.text = subtotalCliente.toString()
        txtTotal.text = totalCliente.toString()


        //Cambiar de Interfaz
        btnRegresar.setOnClickListener{
            startActivity(Intent(this, InterfazDatos::class.java))
        }

    }
}