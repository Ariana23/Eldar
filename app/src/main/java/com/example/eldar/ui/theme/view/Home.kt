package com.example.eldar.ui.theme.view

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.eldar.Router

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController){
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

}