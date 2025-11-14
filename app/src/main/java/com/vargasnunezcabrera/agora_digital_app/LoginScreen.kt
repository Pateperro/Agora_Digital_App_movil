package com.vargasnunezcabrera.agora_digital_app

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

@Preview
@Composable
fun LoginScreen(
    onClickRegister: () -> Unit = {},
    onSuccessfulLogin: () -> Unit = {}
) {
    val auth = Firebase.auth
    val activity = LocalView.current.context as Activity
    val googleSignInClient = getGoogleSignInClient(activity)

    var inputEmail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf("") }
    var usuarioError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var googleError by remember { mutableStateOf<String?>(null) }


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            handleGoogleSignInResult(
                data = result.data,
                auth = auth,
                onSuccess = { onSuccessfulLogin() },
                onError = { error -> googleError = error }
            )
        } else {
            googleError = "Inicio de sesión cancelado"
        }
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .imePadding()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF232121)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "Logo Agora",
                modifier = Modifier
                    .height(200.dp)
                    .width(280.dp)
            )

            Box(
                modifier = Modifier
                    .height(800.dp)
                    .background(
                        color = Color(0xFF3E3A3A),
                        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                    )
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = inputEmail,
                        onValueChange = { inputEmail = it },
                        label = { Text("Email") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedBorderColor = Color(0xFFBDBDBD),
                            unfocusedBorderColor = Color(0xFFBDBDBD),
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(),
                        supportingText = {
                            if (usuarioError.isNotEmpty()) {
                                Text(usuarioError, color = Color.Red)
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = false,
                            keyboardType = KeyboardType.Email
                        )
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    TextButton(onClick = onClickRegister) {
                        Text("¿No tienes una cuenta? Regístrate", color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = inputPassword,
                        onValueChange = { inputPassword = it },
                        label = { Text("Contraseña") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedBorderColor = Color(0xFFBDBDBD),
                            unfocusedBorderColor = Color(0xFFBDBDBD),
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(),
                        supportingText = {
                            if (passwordError.isNotEmpty()) {
                                Text(passwordError, color = Color.Red)
                            }
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.None,
                            autoCorrect = false,
                            keyboardType = KeyboardType.Password
                        )
                    )

                    if (loginError.isNotEmpty()) {
                        Text(
                            loginError,
                            color = Color.Red,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )
                    }



                    Spacer(modifier = Modifier.height(24.dp))


                    Button(
                        onClick = {
                            val isValidEmail = validateEmail(inputEmail).first
                            val isValidPassword = validatePassword(inputPassword).first

                            usuarioError = validateEmail(inputEmail).second
                            passwordError = validatePassword(inputPassword).second

                            if (isValidEmail && isValidPassword) {
                                auth.signInWithEmailAndPassword(inputEmail, inputPassword)
                                    .addOnCompleteListener(activity) { task ->
                                        if (task.isSuccessful) {
                                            onSuccessfulLogin()
                                        } else {
                                            loginError = when (task.exception) {
                                                is FirebaseAuthInvalidCredentialsException -> "Correo o contraseña incorrecta"
                                                is FirebaseAuthInvalidUserException -> "No existe una cuenta con este correo"
                                                else -> "Error al iniciar sesión. Intenta de nuevo"
                                            }
                                        }
                                    }
                            }
                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .height(50.dp)
                            .width(209.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFDAD448),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Login", fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    Button(
                        onClick = {
                            val signInIntent = googleSignInClient.signInIntent
                            launcher.launch(signInIntent)
                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .height(50.dp)
                            .width(209.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFDAD448),

                    ) ){
                        Icon(painterResource(id = R.drawable.google_logo), contentDescription = null, tint = Color.Unspecified )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Google Login", color = Color.White,fontSize = 20.sp)
                    }


                    if (googleError != null) {
                        Text(
                            text = googleError!!,
                            color = Color.Red,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
