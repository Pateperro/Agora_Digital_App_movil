package com.vargasnunezcabrera.agora_digital_app


import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.auth

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RegisterScreen(onClickBack :()->Unit = {}, onSuccessfulRegister :()->Unit = {}) {

    val auth = Firebase.auth
    val activity = LocalView.current.context as Activity

    var inputName by remember { mutableStateOf("") }
    var inputEmail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var inputPasswordConfirmation by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var passwordConfirmationError by remember { mutableStateOf("") }

    var registerError by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
        TopAppBar(
            title = {
            },
            navigationIcon = {
                IconButton(onClick = onClickBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "icon register"
                    )
                }
            }
        )
    }
    ) { innerPadding ->
        Column( modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color(0xFF232121))
            .imePadding()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top )
        { Image( painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo Agora", modifier = Modifier
                .height(200.dp)
                .width(280.dp))


            Box(
                modifier = Modifier
                    .height(800.dp)
                    .background( color = Color(0xFF3E3A3A),
                        shape = RoundedCornerShape( topStart = 50.dp, topEnd = 50.dp ) )
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom=50.dp),
                contentAlignment = Alignment.Center

            )
            { Column( horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center )
            { Text( text = "Registro",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField( value = inputName ,
                    onValueChange = { inputName = it },
                    label = { Text("Nombre") },

                    leadingIcon = { Icon( imageVector = Icons.Default.Person,
                        contentDescription = "User Icon" ) },

                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color(0xFFBDBDBD),
                        unfocusedBorderColor = Color(0xFFBDBDBD),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black ),

                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email
                    )
                    ,
                    supportingText = {
                        if (nameError.isNotEmpty()) {
                            Text(
                                text = nameError,
                                color = Color.Red
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField( value = inputEmail,
                    onValueChange = { inputEmail = it },
                    label = { Text("Email") },
                    leadingIcon = { Icon( imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon" ) }
                    , colors = OutlinedTextFieldDefaults.colors( focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color(0xFFBDBDBD),
                        unfocusedBorderColor = Color(0xFFBDBDBD),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions( capitalization = KeyboardCapitalization.None,
                        autoCorrect = false, keyboardType = KeyboardType.Email )

                    ,
                    supportingText = {
                        if (emailError.isNotEmpty()) {
                            Text(
                                text = emailError,
                                color = Color.Red
                            )
                        }
                    })

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField( value = inputPassword, onValueChange = {inputPassword = it },
                    label = { Text("Contraseña") },
                    leadingIcon = { Icon( imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon" ) }
                    , colors = OutlinedTextFieldDefaults.colors( focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color(0xFFBDBDBD),
                        unfocusedBorderColor = Color(0xFFBDBDBD),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions( capitalization = KeyboardCapitalization.None,
                        autoCorrect = false, keyboardType = KeyboardType.Password ),

                    supportingText = {
                        if (passwordError.isNotEmpty()) {
                            Text(
                                text = passwordError,
                                color = Color.Red
                            )
                        }
                    })


                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField( value = inputPasswordConfirmation, onValueChange = { inputPasswordConfirmation = it},
                    label = { Text("Confirmar Contraseña") },
                    leadingIcon = { Icon( imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon" ) }
                    , colors = OutlinedTextFieldDefaults.colors( focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color(0xFFBDBDBD),
                        unfocusedBorderColor = Color(0xFFBDBDBD),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions( capitalization = KeyboardCapitalization.None,
                        autoCorrect = false, keyboardType = KeyboardType.Password ),
                    supportingText = {
                        if (passwordConfirmationError.isNotEmpty()) {
                            Text(
                                text = passwordConfirmationError,
                                color = Color.Red
                            )
                        }
                    } )


                if (registerError.isNotEmpty()){
                    Text(registerError, color = Color.Red )
                }


                Spacer(modifier = Modifier.height(24.dp))

                Button( onClick = {
                    val isValidName = validateName(inputName).first
                    val isValidEmail = validateEmail(inputEmail).first
                    val isValidPassword = validatePassword(inputPassword).first
                    val isValidConfirmPassword = validateConfirmPassword(inputPassword, inputPasswordConfirmation).first

                    nameError = validateName(inputName).second
                    emailError = validateEmail(inputEmail).second
                    passwordError = validatePassword(inputPassword).second
                    passwordConfirmationError = validateConfirmPassword(inputPassword, inputPasswordConfirmation).second

                    if (isValidName && isValidEmail && isValidPassword && isValidConfirmPassword) {
                        auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                            .addOnCompleteListener(activity) { task ->
                                if (task.isSuccessful) {
                                    onSuccessfulRegister()
                                } else {
                                    registerError = when (task.exception) {
                                        is FirebaseAuthInvalidCredentialsException -> "Correo inválido"
                                        is FirebaseAuthUserCollisionException -> "Correo ya registrado"
                                        else -> "Error al registrarse"
                                    }
                                }
                            }
                    }
                    else {
                        registerError = "Hubo un error en el register"
                    }
                },

                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier .height(50.dp) .width(180.dp),
                    colors = ButtonDefaults.buttonColors( containerColor = Color(0xFFDAD448),
                        contentColor = Color.White ) ) { Text("Registrarse", fontSize = 20.sp)

                } } } } } }