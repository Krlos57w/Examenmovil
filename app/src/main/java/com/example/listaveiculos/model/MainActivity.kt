package com.example.listaveiculos.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import com.example.listaveiculos.Adapters.VehiculoAdapter
import com.example.listaveiculos.R
import com.example.listaveiculos.databinding.ActivityMainBinding
import com.example.listaveiculos.model.Vehiculos
import okhttp3.internal.notify

class MainActivity : AppCompatActivity(), View.OnClickListener {/* View.OnClickListener actividad responderá a eventos de clic en vistas. */
    lateinit var binding : ActivityMainBinding  /*var para uso posterior...ActivityMainBinding para enlazar elementos de la interfaz de usuario*/
    lateinit var listaVehiculos : ArrayList<Vehiculos> /*ArrayList de objetos instancia de VehiculoAdapter..mostrar la lista en la interfaz*/
    lateinit var adapter : VehiculoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) /*enlace de elementos de la interfaz de usuario que defini en activity_main.xml a través de binding.*/
        listaVehiculos = ArrayList() /*instancia de ArrayList llamada listaVehiculos para almacenar los objetos Vehiculos.*/
        adapter = VehiculoAdapter(this,listaVehiculos)
        binding.btnGuardar.setOnClickListener(this) /*Asignar un OnClickListener al botón con ID btnGuardar para que el método onClick se llame cuando se haga clic en ese botón.*/
    }

    override fun onClick(v: View?) {/*llamar cuando se hace clic en una vista con un OnClickListener...btnGuardar */
        if (v?.id == R.id.btnGuardar){ /*verificar el id es btnGuardar */
            //

            //

            var vehic :Vehiculos= Vehiculos(binding.etNombreAuto.text.toString(), binding.etModelo.text.toString().toInt(),binding.etColor.text.toString(),binding.etCilindraje.text.toString().toInt(),binding.etprecio.text.toString().toInt(),binding.txtUrlImage.text.toString())/*Objeto Vehiculos utilizando los valores ingresados por el usuario de los campos de texto (etNombreAuto, etModelo,...*/
            listaVehiculos.add(vehic)/*objeto se agrega a la lista*/
            binding.etNombreAuto.text.clear()/* borrar el contenido de los campos para permitir nuevos datos.*/
            binding.etModelo.text.clear()
            binding.etColor.text.clear()
            binding.etCilindraje.text.clear()
            /*binding.etCantidadPuertas.text.clear()*/
            binding.etprecio.text.clear()
            binding.txtUrlImage.text.clear()
            binding.listaVehiculos.adapter = adapter
            adapter.notifyDataSetChanged()/* para notificar al adaptador de los cambios en los datos */
        }
    }
}