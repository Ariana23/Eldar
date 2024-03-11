package com.example.eldar.ui.theme.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.eldar.localdatabase.AppDB
import com.example.eldar.localdatabase.CardData
import com.example.eldar.localdatabase.Contract

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCard(navController: NavController){
   var listCard = mutableListOf<CardData>()
   val context = LocalContext.current
   val db = Room.databaseBuilder(
      context,
      AppDB::class.java,
      Contract.DB.NAME)
      .allowMainThreadQueries()
      .build()
   listCard = db.cardDao().getListCard().toMutableList()
   Scaffold (
      modifier = Modifier.fillMaxSize(),
      topBar = {
         TopAppBar(
            title = {
               Text(
                  modifier = Modifier.padding(start = 30.dp),
                  text = "Lista de Tarjetas")
         },
            navigationIcon = {
               Icon(
                  modifier = Modifier
                     .size(50.dp)
                     .clickable {
                        navController.popBackStack()
                     },
                  imageVector = Icons.Filled.ArrowBack,
                  contentDescription ="")
            }
            )
      }
   ){
      LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 90.dp)){
         itemsIndexed(listCard){pos, w ->
            Row (modifier = Modifier.fillMaxWidth()){
               Text(
                  modifier = Modifier.weight(0.5f),
                  text = "${w.name}")
               Text(
                  modifier = Modifier.weight(0.5f),
                  text = "${w.lastName}")
            }
         }
      }

   }
}