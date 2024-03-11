package com.example.eldar.localdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SesionDao {
    @Insert()
    fun initSesion(user:SesionData)
    @Query("SELECT * FROM ${Contract.DB.SESION_TBL}")
    fun getSessionState():SesionData
    @Query("DELETE FROM ${Contract.DB.SESION_TBL}")
    fun closeSession()
}