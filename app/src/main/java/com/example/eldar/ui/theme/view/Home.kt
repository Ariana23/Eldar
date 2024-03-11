package com.example.eldar.ui.theme.view

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eldar.R
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
    ) {
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
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Text(
                text = "Saldo",
                color = Color(0xFF1C478B),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(15.dp),
                fontSize = 18.sp,
            )
            Text(
                text = "$ 286.182",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF1C478B),
                fontSize = 32.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp),
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            colors = ButtonDefaults.buttonColors(Color(18, 64, 118)),
            modifier = Modifier.padding(20.dp),
            onClick = {
                navController.navigate(Router.LIST_CARD.route)
            }) {
            Text(
                color = Color.White,
                fontSize = 18.sp,
                text = "Lista de tarjetas"
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                shape = RoundedCornerShape(25.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 18.dp,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1C478B)
                ),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.visa_symbol),
                            contentDescription = "",
                            modifier = Modifier
                                .size(60.dp)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,

                        ) {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.visa),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(60.dp)
                            )
                        }
                    }

                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "**************1234",
                        color = Color.White,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Nombre y Apellido",
                            color = Color.Gray
                        )
                        Text(
                            text = "Juana Codoba Alvero",
                            color = Color.White
                        )
                    }
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Fecha de vencimiento",
                            color = Color.Gray
                        )
                        Text(
                            text = "07/27",
                            color = Color.White
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(shape = RoundedCornerShape(6.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
                .height(80.dp),
            colors = ButtonDefaults.buttonColors(Color(215, 228, 192)),
            onClick = {
                navController.navigate(Router.ADD_CARD.route)
            }) {
            Text(
                fontSize = 22.sp,
                text = "AGREGAR TARJETA",
                color = Color(0xFF1C478B)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Button(shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1C478B)),
                onClick = {
                    navController.navigate(Router.ADD_CARD.route)
                }) {
                Text(
                    fontSize = 22.sp,
                    text = "PAGAR CON TARJETA",
                    color = Color.White
                )
            }
            Button(shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF1C478B)),
                onClick = {
                    navController.navigate(Router.ADD_CARD.route)
                }) {
                Text(
                    fontSize = 22.sp,
                    text = "PAGAR CON QR",
                    color = Color.White
                )
            }

        }
    }

}
