package com.example.eldar.localdatabase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(
            entities = [
                CardData::class,
            SesionData::class
            ],
        version = 1,
        exportSchema = true
    )
    abstract class AppDB: RoomDatabase(){
        abstract fun cardDao(): CardDao
        abstract fun SessionDao(): SesionDao
    }
