package com.example.eldar.localdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Contract.ListaTbl.TABLE_NAME)
data class CardData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo (name = Contract.ListaTbl.Name) val name: String,
    @ColumnInfo (name = Contract.ListaTbl.LAST_NAME) val lastName: String,
    @ColumnInfo (name = Contract.ListaTbl.ESPECIALIDAD) val especialidad: String


)
@Entity(tableName = Contract.DB.SESION_TBL)
data class SesionData(
    @PrimaryKey @ColumnInfo(name = Contract.SesionTbl.USER) val user: String,
    @ColumnInfo(name = Contract.SesionTbl.FECHA_INICIO) val fechaInicio: String
)
