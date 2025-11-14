package com.vargasnunezcabrera.agora_digital_app

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun EpocaFilosoficaScreen(nombreEpoca: String, onBack: () -> Unit) {
    val epoca = EpocasRepository.getEpocaById(nombreEpoca)

    if (epoca == null) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                Text("No se encontró la época seleccionada")
            }
        }

        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(epoca.nombre) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D3D3D))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = epoca.imagenPrincipal),
                contentDescription = epoca.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = epoca.descripcion,
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(16.dp)
            )

            HorizontalDivider(thickness = 2.dp, color = Color.Black)

            Text(
                text = "Línea de tiempo",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            // Línea de tiempo vertical
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                epoca.eventos.forEachIndexed { index, evento ->
                    TimelineNode(evento, isLast = index == epoca.eventos.size - 1)
                }
            }
        }
    }
}

@Composable
fun TimelineNode(evento: EventoHistorico, isLast: Boolean) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        if (!isLast) {
            Box(
                modifier = Modifier
                    .width(3.dp)
                    .fillMaxHeight()
                    .padding(start = 28.dp) // alineación con el nodo
                    .background(Color.Gray)
                    .align(Alignment.CenterStart)
            )
        }

        //  Tarjeta (con espacio a la izquierda para el nodo)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp) // espacio donde va el nodo
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFF7F7F7))
                .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
                .clickable { expanded = !expanded }
                .animateContentSize()
                .padding(12.dp)
        ) {
            Column {
                Text(
                    text = evento.fecha,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333)
                )

                Image(
                    painter = painterResource(id = evento.imagen),
                    contentDescription = evento.titulo,
                    modifier = Modifier
                        .height(if (expanded) 200.dp else 120.dp)
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = evento.titulo,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = if (expanded) evento.descripcionDetallada else evento.descripcionCorta,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        // 🔹 Nodo centrado verticalmente (a la izquierda de la tarjeta)
        Box(
            modifier = Modifier
                .size(28.dp)
                .background(Color(0xFF000000), shape = RoundedCornerShape(14.dp))
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
        )
    }
}
