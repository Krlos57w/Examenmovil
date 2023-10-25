package com.example.listaveiculos.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import coil.transform.CircleCropTransformation
import com.example.listaveiculos.databinding.VehiculoCellBinding

import com.example.listaveiculos.model.Vehiculos

class VehiculoAdapter(val c:Context,val datos: ArrayList<Vehiculos>) : BaseAdapter() {/* argumentos en el constructor: */
    var context: Context
    var data: ArrayList<Vehiculos>

    init {
        context = c
        data = datos
    }

    override fun getCount(): Int {/*Devuelve la cantidad de elementos en la lista de vehículos (data).*/
        return data.size
    }

    override fun getItem(p0: Int): Any {/* Devuelve el objeto Vehiculos en una posición específica de la lista.*/
        return data.get(p0)
    }

    override fun getItemId(p0: Int): Long {/*Devuelve un ID único para el elemento en una posición específica.*/
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {/*obtener la vista que representa un elemento en una posición específica de la lista.*/
        var holder: ViewHolder

        if (convertView == null){/*verifica si convertView es nulo*/
            var itemBinding =
                VehiculoCellBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
            holder = ViewHolder(itemBinding)
            holder.view = itemBinding.root
            holder.view.tag = holder

        }
        else {
            holder = convertView.tag as ViewHolder
        }
        val Vehiculos = data.get(position)
        holder.binding.txtNombre.text = Vehiculos.nombre
        //holder.binding.txtprecio.text = Vehiculos.precio.toString()

        if (Vehiculos.color.equals("amarillo", ignoreCase = true)) {
            val precio = Vehiculos.precio.toDouble()
            val descuento = precio * 0.1
            val precioConDescuento = precio - descuento
            holder.binding.txtprecio.text = "Precio: ${precioConDescuento.toString()}"
        }else {
            holder.binding.txtprecio.text = "Precio: ${Vehiculos.precio.toString()}"
        }

        //
        holder.binding.imgAvatar.load(Vehiculos.url) {
            transformations(CircleCropTransformation())
        }
        return holder.view

    }

    class ViewHolder(itemBinding: VehiculoCellBinding) {
        var view: View
        var binding: VehiculoCellBinding

        init {
            view = itemBinding.root
            binding = itemBinding
        }

    }
}

