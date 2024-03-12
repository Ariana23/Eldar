package com.example.eldar.localdatabase

class Contract {
    //BASE DE DATOS
    object DB {
        const val NAME = "Tarjetas.db"
        const val SESION_TBL = "SesionTbl"
    }

    //TABLA DE TARJETAS
    object ListaTbl{
        const val TABLE_NAME = "tarjetasTbl"
        const val Name = "nameTarjeta"
        const val LAST_NAME = "lastNameTarjeta"
        const val ESPECIALIDAD = "especialidadLista"


    }
    object SesionTbl{
        const val USER = "user"
        const val FECHA_INICIO = "fechaInicio"

    }
}