package com.example.eldar.ui.theme.view

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eldar.Router

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController){
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(18, 64, 118)),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth(),

            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp,)
        ) {
            //ACA ESTA EL "HOLA" BANNER
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Hola, Tester",
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Normal,
                fontSize = 17.sp,
                color = Color.White
            )

        }
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation =  10.dp,),
            colors = CardDefaults.cardColors(
                containerColor = Color.White),
         ){
            Text(
                text = "Campus",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color(18, 91, 80),
                fontSize = 32.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp, top = 1.dp, bottom = 1.dp),
               )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate(Router.ADD_CARD.route)
        }) {
            Text(text = "AGREGAR TARJETA")
        }

        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate(Router.LIST_CARD.route)
        }) {
            Text(text = "Lista de tarjetas")
        }
    }

}

    /*
    Scaffold(
        modifier = Modifier,
        topBar = {
                 CenterAlignedTopAppBar(
                     title = { Text(text = "ELDAR") },
                     actions = {
                         IconButton(onClick = {
                             navController.navigate(Router.LIST_CARD.route)
                         }) {
                             androidx.compose.material3.Icon(
                                 imageVector = Icons.Filled.List,
                                 contentDescription =""
                             )
                             
                         }
                     }

                 )
        },
        
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Router.ADD_CARD.route)
            }) {
               androidx.compose.material3.Icon(imageVector = Icons.Filled.Add, contentDescription ="" )

            }
        }
    ) {

    }
    Column {
        Card {
            Text(text = "holi")
        }
    }

}*/