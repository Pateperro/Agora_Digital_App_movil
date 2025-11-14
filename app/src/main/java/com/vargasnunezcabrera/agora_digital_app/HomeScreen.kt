package com.vargasnunezcabrera.agora_digital_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickHistoria: () -> Unit = {},
    onClickFilosofos: () -> Unit = {},
    onClickEstudios: () -> Unit = {},
    onClickGlosario: () -> Unit = {},
    onClickProfile: () -> Unit = {}

){
    val auth = Firebase.auth
    val user = auth.currentUser

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.agorasinfondo),
                        contentDescription = "Logo de la App",
                        modifier = Modifier.size(120.dp)
                    )
                },
                actions = {

                    val auth = Firebase.auth
                    val user = auth.currentUser


                    val userName = user?.displayName ?: "Usuario"

                    Box(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFFE6E6E6))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = userName,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(end = 8.dp)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.catinsock),
                                contentDescription = "Foto de perfil",
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(RoundedCornerShape(50))
                                    .clickable { onClickProfile() }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3D3D3D)
                )
            )

        }


    ) { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment =Alignment.CenterHorizontally
        ){
            Spacer(Modifier.height(16.dp))

            HorizontalDivider(thickness = 2.dp, color = Color.Black)
            Text(
                text = "En la Ágora Digital encontrarás la historia de la filosofía, biografía de los filósofos más importantes, ejercicios y más.",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
            HorizontalDivider(thickness = 2.dp, color = Color.Black)

            val opciones = listOf(
                "Historia de la Filosofía" to R.drawable.lineatiempo,
                "Mis Estudios" to R.drawable.ejercicios,
                "Filósofos/as" to R.drawable.nietzsche_famosos,
                "Glosario Filosófico" to R.drawable.glosario
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .heightIn(min = 400.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(opciones) { (titulo, imagen) ->
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFF7F7F7))
                            .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                            .clickable {
                                when(titulo) {
                                    "Historia de la Filosofía" -> onClickHistoria()
                                    "Filósofos/as" -> onClickFilosofos()
                                    "Mis Estudios" -> onClickEstudios()
                                    "Glosario Filosófico" -> onClickGlosario()
                                }
                            }
                        ,
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = imagen),
                                contentDescription = titulo,
                                modifier = Modifier
                                    .size(90.dp)
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                text = titulo,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }


        }
    }

}