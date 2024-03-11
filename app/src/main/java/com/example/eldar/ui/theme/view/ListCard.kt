package com.example.eldar.ui.theme.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
      modifier = Modifier,
      topBar = {
         TopAppBar(
            title = {
               Text(
                  modifier = Modifier.padding(start = 30.dp),
                  text = "Atrás")
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
   ) {
      Column(
         modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Spacer(modifier = Modifier.height(70.dp))
         Text(
            "Lista de Tarjetas:",
            modifier = Modifier.width(300.dp),
            color = Color(0xFF1C478B),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
         )
         Spacer(modifier = Modifier.height(20.dp))
         LazyColumn(modifier = Modifier) {
            itemsIndexed(listCard) { pos, w ->
               Card(
                  modifier = Modifier
                     .padding(16.dp)
                     .fillMaxWidth()
                     .fillMaxHeight(),
                  shape = RoundedCornerShape(25.dp),
                  elevation = CardDefaults.cardElevation(
                     defaultElevation =  18.dp,),
                  colors = CardDefaults.cardColors(
                     containerColor = Color(0xFF1C478B)
                  )
               ) {
                     Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Nombre del Usuario: ${w.name}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color.White
                     )
                     Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Nombre de la Tarjeta: ${w.lastName}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color.White
                     )

                  Text(
                     modifier = Modifier.padding(10.dp),
                     text = "Número de Tarjeta: ${w.especialidad}",
                     fontWeight = FontWeight.Bold,
                     fontSize = 22.sp,
                     color = Color.White
                  )

               }

            }
         }

      }
   }
}