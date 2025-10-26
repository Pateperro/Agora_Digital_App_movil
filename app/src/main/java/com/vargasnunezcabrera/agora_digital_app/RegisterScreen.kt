package com.vargasnunezcabrera.agora_digital_app


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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun RegisterScreen() {
    Scaffold { paddingValues ->
        Column( modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color(0xFF232121)),
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

                OutlinedTextField( value = "" , onValueChange = { },
                    label = { Text("Usuario") },
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
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField( value = "", onValueChange = { },
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
                        autoCorrect = false, keyboardType = KeyboardType.Email ) )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField( value = "", onValueChange = { },
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
                        autoCorrect = false, keyboardType = KeyboardType.Password ) )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField( value = "", onValueChange = { },
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
                        autoCorrect = false, keyboardType = KeyboardType.Password ) )



                Spacer(modifier = Modifier.height(24.dp))

                Button( onClick = { /* TODO: Login action */ },

                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier .height(50.dp) .width(180.dp),
                    colors = ButtonDefaults.buttonColors( containerColor = Color(0xFFDAD448),
                        contentColor = Color.White ) ) { Text("Registrarse", fontSize = 20.sp)

                } } } } } }