package com.example.listaveiculos.model

class Vehiculos (nombre:String,modelo:Int,color:String,cilidraje:Int,precio:Int,url:String){
    var nombre:String;
    var modelo:Int
    var color:String
    var cilidraje:Int
    var precio: Int /*var cantidadPuertas:Int*/
    var url:String

    init {
        this.nombre=nombre
        this.modelo=modelo
        this.color=color
        this.cilidraje=cilidraje
        this.precio=precio /*this.cantidadPuertas=cantidadPuertas*/
        this.url=url
    }
}