package com.vargasnunezcabrera.agora_digital_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import com.vargasnunezcabrera.agora_digital_app.ui.theme.Agora_Digital_AppTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import java.net.URLDecoder


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
                    popUpTo(0) { inclusive = true }
                }
            },
                onClickHistoria = {
                    myNavController.navigate("historia")
                },
                        onClickGlosario = {
                    myNavController.navigate(("glosario"))

                }
            )


        }


        composable("historia") {
            HistoriaFilosofiaScreen(
                onClickEpocaFilosofica = { epocaId ->
                    val encodedEpoca = URLEncoder.encode(epocaId, StandardCharsets.UTF_8.toString())
                    myNavController.navigate("epocaFilosofica/$encodedEpoca")
            })
        }

        composable(
            "epocaFilosofica/{epocaId}",
            arguments = listOf(navArgument("epocaId") {type = NavType.StringType })
        ) { backStackEntry ->
            val encodedNombre = backStackEntry.arguments?.getString("epocaId") ?: ""
            val epocaId = URLDecoder.decode(encodedNombre, StandardCharsets.UTF_8.toString())

            EpocaFilosoficaScreen(epocaId){
                myNavController.popBackStack()
            }
        }
        composable("glosario") {
            GlosarioScreen(  onClickBack = { myNavController.popBackStack() })
        }


    }



}
