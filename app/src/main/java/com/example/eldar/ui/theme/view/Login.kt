package com.example.eldar.ui.theme.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eldar.Router
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun Login(navController: NavController) {

    val dbFirebase = Firebase.firestore
    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    var onLogin = remember { mutableStateOf(false) }

    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            var passwordVisibility = remember { mutableStateOf(false) }
            Text(
                text = "BIENVENIDO",
                fontSize = 34.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(0.8f),
                placeholder = { Text(text = "Nombre de Usuario") },
                value = userName.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = {
                    if (it.length < 25) {
                        userName.value = it
                    }
                }
            )
            OutlinedTextField( modifier = Modifier.fillMaxWidth(0.8f),
                placeholder = { Text(text = "Contraseña") },
                value = password.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                        Icon(
                            imageVector = if (passwordVisibility.value) {
                                Icons.Default.Check
                            } else {
                                Icons.Default.Close
                            },
                            contentDescription = ""
                        )
                    }
                },
                visualTransformation = if (passwordVisibility.value) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },

                onValueChange = {
                    if (it.length < 15) {
                        password.value = it
                    }
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
    OutlinedButton(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 3.dp)
            .fillMaxWidth()
            .height(50.dp),
        onClick = {
            if (userName.value.isBlank() || password.value.isBlank())
                Toast.makeText(context, "Completa los datos", Toast.LENGTH_SHORT).show()
            else {
                onLogin.value = true
            }

        }) {
        Text(
            text = "Inciar Sesión",
            fontSize = 24.sp,
        )

    }
            if (onLogin.value) {
                dbFirebase.collection("usuarios")
                    .document("ari@hotmail.com")
                    .get()
                    .addOnSuccessListener { usuario ->
                        if (usuario != null) {
                            val pwd = usuario.get("password")
                            if (pwd!!.equals(password.value)) {
                                navController.navigate(Router.HOME.route)
                                Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(context, "Usuario no existe", Toast.LENGTH_SHORT).show()
                        }
                    }
                onLogin.value = false


            }
        }//CIERRA EL COLUMN
    }//CIERRA EL SCALFFOLD
}//CIERRA LA FUNCION




