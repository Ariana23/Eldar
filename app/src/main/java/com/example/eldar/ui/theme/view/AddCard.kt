package com.example.eldar.ui.theme.view

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import androidx.room.RoomDatabase
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.eldar.R
import com.example.eldar.localdatabase.AppDB
import com.example.eldar.localdatabase.CardData
import com.example.eldar.localdatabase.Contract


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCard(navController: NavController){
    val nombreData : MutableState<String> = remember { mutableStateOf("") }
    val apellidosData : MutableState<String> = remember { mutableStateOf("") }
    val especialidadData : MutableState<String> = remember { mutableStateOf("") }
    val fechaData : MutableState<String> = remember { mutableStateOf("") }

    val context: Context = LocalContext.current

    val db: AppDB = Room.databaseBuilder(
        context,
        AppDB::class.java,
        Contract.DB.NAME)
        .allowMainThreadQueries()
        .build()

    val tarjetaD = db.cardDao()
 Scaffold(
     modifier = Modifier.fillMaxSize(),
     topBar = {
         TopAppBar(
             title = {Text(text = "Atrás")},
             navigationIcon = {
                 Icon(
                     modifier = Modifier.clickable {
                            navController.popBackStack()
                     },
                     imageVector = Icons.Filled.ArrowBack,
                     contentDescription ="" )
             }
         )
     }

 ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text("Completar los Datos:",
            modifier = Modifier.width(300.dp),
            color = Color(0xFF1C478B),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier.width(300.dp),
            label = { Text(text = "Nombre Usuario")},
            value = nombreData.value,
            onValueChange = {
                if (it.length < 40)
                    nombreData.value = it
            })
        OutlinedTextField(
            modifier = Modifier.width(300.dp),
            label = { Text(text = "Tarjeta")},
            value = apellidosData.value,
            onValueChange = {
                if (it.length < 40)
                    apellidosData.value = it
            })
        OutlinedTextField(
            modifier = Modifier.width(300.dp),
            label = { Text(text = "Número")},
            value = especialidadData.value,
            onValueChange = {
                if (it.length < 60)
                    especialidadData.value = it
            })

        OutlinedButton(
            modifier = Modifier.padding(top = 40.dp),
            onClick = {
                val w = CardData(id = 0,
                    name = nombreData.value,
                    lastName = apellidosData.value,
                    especialidad = especialidadData.value
                )
                tarjetaD.newCard(w)
                Toast.makeText(context, "Tarjeta Registrada", Toast.LENGTH_SHORT).show()
                navController.popBackStack()

            }) {
            Text(text ="Guardar datos de la Tarjeta",
                fontSize = 18.sp,
                color = Color(0xFF1C478B)
                )
        }
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animasionlogin))
        LottieAnimation(composition = composition,
            modifier = Modifier
                .size(400.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
 }
}