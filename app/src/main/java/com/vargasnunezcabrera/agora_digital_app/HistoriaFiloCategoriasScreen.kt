package com.vargasnunezcabrera.agora_digital_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

data class EpocaFilosofica(
    val titulo: String,
    val descripcion: String,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun HistoriaFilosofiaScreen() {
    val listaEpocas = listOf(
        EpocaFilosofica("Filosofía Antigua", "Conjunto de pensamientos que surgieron en Grecia y Roma.", R.drawable.historia_filosofia),
        EpocaFilosofica("Filosofía Medieval", "Basada en la fe y la razón durante la Edad Media.", R.drawable.filosofia_medieval),
        EpocaFilosofica("Filosofía Moderna", "Surge en el Renacimiento con el pensamiento racionalista.", R.drawable.filosofiamoderna),
        EpocaFilosofica("Siglo XIX", "Caracterizada por corrientes como el idealismo y positivismo.", R.drawable.sigloxix),
        EpocaFilosofica("Filosofía Contemporánea", "Diversidad de corrientes del siglo XX en adelante.", R.drawable.filosofiacontemporanea)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.agorasinfondo),
                        contentDescription = "Logo de la App",
                        modifier = Modifier.height(40.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3D3D3D)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Explora las diferentes épocas de la filosofía a lo largo de la historia.",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(vertical = 8.dp),
                fontWeight = FontWeight.Medium
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Black)

            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(listaEpocas) { epoca ->
                    EpocaCard(epoca)
                }
            }
        }
    }
}

@Composable
fun EpocaCard(epoca: EpocaFilosofica) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF7F7F7))
            .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
            .clickable { /* Aquí podrías navegar a detalle */ }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = epoca.imagen),
                contentDescription = epoca.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = epoca.titulo,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = epoca.descripcion,
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}