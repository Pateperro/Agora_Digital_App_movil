package com.vargasnunezcabrera.agora_digital_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vargasnunezcabrera.agora_digital_app.ui.theme.Agora_Digital_AppTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


@Composable

fun NavigationApp(){
    val myNavController = rememberNavController()
    var myStartDestination: String = "login"

    val auth = Firebase.auth
    val currentUser = auth.currentUser

    if (currentUser != null) {
        myStartDestination = "home"
    } else {
        myStartDestination = "login"
    }


    NavHost(
        navController = myNavController,
        startDestination = myStartDestination
    ) {
        composable("login") {
            LoginScreen(onClickRegister = {
                myNavController.navigate("register")
            }, onSuccessfulLogin = {
                myNavController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }
        composable("register") {
            RegisterScreen(onClickBack = {
                myNavController.popBackStack()
            }, onSuccessfulRegister = {
                myNavController.navigate("home") {
                    popUpTo(0)
                }
            })
        }

        composable("home") {
            HomeScreen(onClickLogout = {
                myNavController.navigate("login") {
                    popUpTo(0)
                }
            })
        }

        composable("historia") {
            HistoriaFilosofiaScreen(
                onClickEpocaFilosofica = { nombreEpoca ->
                    myNavController.navigate("epocaFilosofica/$nombreEpoca")
            })
        }

        composable("epocaFilosofia/{nombreEpoca}",
            arguments = listOf(navArgument("nombreEpoca") {type = NavType.StringType })
        ) { backStackEntry ->
            val  nombreEpoca = backStackEntry.arguments?.getString("nombreEpoca") ?: ""
            EpocaFilosoficaScreen(nombreEpoca){
                myNavController.popBackStack()
            }
        }

    }


}
