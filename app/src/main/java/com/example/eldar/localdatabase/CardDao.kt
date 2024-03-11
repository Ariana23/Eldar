package com.example.eldar.localdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CardDao {
    @Insert()
    fun newCard(card: CardData)
    @Query("SELECT * FROM ${Contract.ListaTbl.TABLE_NAME}")
    fun getListCard(): List<CardData>

}