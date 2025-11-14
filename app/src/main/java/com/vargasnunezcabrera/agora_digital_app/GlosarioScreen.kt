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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GlosarioScreen(
    onClickBack: () -> Unit = {}
) {
    val alphabet = ('A'..'Z').toList()
    var selectedLetter by remember { mutableStateOf<Char?>(null) }

    val glossary = listOf(
        "A priori: Conocimiento independiente de la experiencia.",
        "A posteriori: Conocimiento basado en la experiencia.",
        "Alienación: Sentimiento de separación del propio ser o del mundo.",
        "Arquetipo: Modelo universal o primigenio",
        "Bien supremo: Fin último y máximo bienestar que busca el ser humano.",
        "Categorías: Conceptos fundamentales para estructurar la realidad.",
        "Cosmovisión: Manera general de interpretar el mundo.",
        "Contrato social: Acuerdo teórico que fundamenta la vida en sociedad.",
        "Deontología: Ética basada en el deber.",
        "Determinismo: Doctrina que sostiene que todo efecto tiene una causa necesaria.",
        "Dualismo: División entre cuerpo-mente o entre dos sustancias.",
        "Epistemología: Rama que estudia el conocimiento.",
        "Esencia: Aquello que define lo que algo es.",
        "Escepticismo: Postura que duda de la posibilidad de conocer la verdad.",
        "Finalismo: Doctrina que explica los fenómenos por sus fines.",
        "Forma: En Aristóteles, aquello que da estructura a la materia.",
        "Hedonismo: Doctrina que identifica el bien con el placer.",
        "Humanismo: Corriente que pone al ser humano en el centro.",
        "Idea: En Platón, realidad perfecta e inmutable.",
        "Imperativo categórico: Principio moral universal de Kant.",
        "Inmanentismo: Postura que rechaza lo trascendente.",
        "Metafísica: Estudio del ser, la realidad y sus principios.",
        "Moral: Conjunto de normas que guían el comportamiento.",
        "Ontología: Rama que estudia el ser.",
        "Objeto: Aquello que es conocido por un sujeto.",
        "Pragmatismo: Corriente que evalúa la verdad por su utilidad práctica.",
        "Paradigma: Modelo conceptual dominante.",
        "Racionalismo: Doctrina que da primacía a la razón.",
        "Realismo: Postura que afirma la existencia de una realidad independiente de la mente.",
        "Ser: Concepto central que se refiere a la existencia.",
        "Sofisma: Argumento falso que parece verdadero.",
        "Sujeto: Ser que conoce, piensa o percibe.",
        "Teleología: Explicación de los fenómenos por sus fines.",
        "Trascendencia: Lo que va más allá de la experiencia o del mundo físico.",
        "Virtud: Disposición a obrar bien (Aristóteles).",
        "Voluntad de poder: Concepto central de Nietzsche."
    )

    val filteredGlossary = selectedLetter?.let { letter ->
        glossary.filter { it.startsWith(letter, ignoreCase = true) }
    } ?: glossary

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.agorasinfondo),
                        contentDescription = "Logo de la App",
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3D3D3D)
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
                    text = "Aquí encontrarás conceptos claves sobre el mundo de la filosofía.",
                    fontSize = 16.sp,
                    color = Color(0xFF555555)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Alfabeto
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

            // Lista glosario
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
                        elevation = CardDefaults.elevatedCardElevation(4.dp),
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


