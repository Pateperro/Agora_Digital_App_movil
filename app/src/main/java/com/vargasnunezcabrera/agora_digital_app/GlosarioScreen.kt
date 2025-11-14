package com.vargasnunezcabrera.agora_digital_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlosarioScreen() {
    val alphabet = ('A'..'Z').toList()
    var selectedLetter by remember { mutableStateOf<Char?>(null) }

    val glossary = listOf(
        "Amor: sentimiento profundo de afecto.",
        "Bienestar: estado de satisfacción y equilibrio.",
        "Conocimiento: conjunto de información y entendimiento.",
        "Duda: incertidumbre ante un concepto o situación.",
        "Ética: estudio de la moral y la conducta correcta."
    )

    val filteredGlossary = selectedLetter?.let { letter ->
        glossary.filter { it.startsWith(letter, ignoreCase = true) }
    } ?: glossary

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(R.drawable.agorasinfondo),
                        contentDescription = "Agora Digital",
                        modifier = Modifier.size(100.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF232121)
                )
            )
        },
        containerColor = Color(0xFFF5F5F5)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Fondo del título
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFE9E2F8))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Glosario Filosófico",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF232121),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Aquí encontrarás conceptos claves sobre el mundo de la filosofía que te ayudarán a orientarte en tus estudios",
                    fontSize = 16.sp,
                    color = Color(0xFF555555)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Barra del alfabeto
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                alphabet.forEach { letter ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(36.dp)
                            .background(
                                color = if (letter == selectedLetter) Color(0xFF3FB1AD) else Color(0xFFE0E0E0),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable {
                                selectedLetter = if (selectedLetter == letter) null else letter
                            }
                    ) {
                        Text(
                            text = letter.toString(),
                            fontWeight = FontWeight.Bold,
                            color = if (letter == selectedLetter) Color.White else Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de conceptos
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                filteredGlossary.forEach { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "→ $item",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(16.dp),
                            color = Color(0xFF333333)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GlosarioScreenPreview() {
    GlosarioScreen()
}
