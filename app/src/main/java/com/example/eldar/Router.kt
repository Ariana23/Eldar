package com.example.eldar

sealed class Router(val route: String){
    object HOME: Router("Home")
    object LOG_IN: Router("LogIn")
    object ADD_CARD: Router("AddCard")
    object LIST_CARD: Router("ListCard")

}
