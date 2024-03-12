package com.example.eldar

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.eldar.localdatabase.AppDB
import com.example.eldar.localdatabase.Contract
import com.example.eldar.ui.theme.EldarTheme
import com.example.eldar.ui.theme.view.AddCard
import com.example.eldar.ui.theme.view.Home
import com.example.eldar.ui.theme.view.ListCard
import com.example.eldar.ui.theme.view.Login
import com.example.eldar.ui.theme.view.QRCodeApp

class MainActivity : ComponentActivity() {
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = applicationContext
        setContent {
            EldarTheme {
                val navController = rememberNavController()
                val db =  Room.databaseBuilder(
                    context,
                    AppDB::class.java,
                    Contract.DB.NAME)
                    .allowMainThreadQueries()
                    .build()
                val sessionState = db.SessionDao().getSessionState()
                NavHost(navController = navController,
                    startDestination =
                    if(sessionState == null) Router.LOG_IN.route else Router.HOME.route){
                    composable(Router.LOG_IN.route){
                        Login(navController)
                    }
                        composable(Router.HOME.route){
                            Home(navController = navController)
                        }
                    composable(Router.ADD_CARD.route){
                        AddCard(navController = navController)
                    }
                    composable(Router.LIST_CARD.route){
                        ListCard(navController = navController)
                    }
                    composable(Router.QR_CARD.route){
                        QRCodeApp(navController = navController)
                    }

                }

            }
        }
    }
}
