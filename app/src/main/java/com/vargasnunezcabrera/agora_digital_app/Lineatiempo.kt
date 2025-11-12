package com.vargasnunezcabrera.agora_digital_app

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column // <-- Solicitada
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer // <-- Solicitada
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// 1. DATA CLASS
data class PhilosopherModel(
    val id: Int,
    val name: String,
    val period: String,
    val dates: String,
    @DrawableRes val imageId: Int, // Usar anotación para el ID del recurso de la imagen
    val shortSummary: String,
    val fullBiography: String
)

// Datos de ejemplo (Asegúrate de tener estos drawables en tu proyecto)
val medievalPhilosophers = listOf(
    PhilosopherModel(
        id = 1,
        name = "San Agustín de Hipona",
        period = "Patrística",
        dates = "354 - 430 d.C.",
        imageId = R.drawable.ic_launcher_background, // **Reemplazar con tu recurso**
        shortSummary = "Inició la filosofía cristiana con su síntesis de la fe (revelación) y la razón (neoplatonismo). Su obra 'Confesiones' es central.",
        fullBiography = "Texto completo de la biografía y pensamiento..."
    ),
    PhilosopherModel(
        id = 2,
        name = "Boecio",
        period = "Alta Edad Media",
        dates = "480 - 524 d.C.",
        imageId = R.drawable.ic_launcher_background, // **Reemplazar con tu recurso**
        shortSummary = "Figura de transición. Preservó el conocimiento clásico y su 'Consolación de la Filosofía' influyó enormemente.",
        fullBiography = "Texto completo de la biografía y pensamiento..."
    ),
    PhilosopherModel(
        id = 3,
        name = "Santo Tomás de Aquino",
        period = "Alta Escolástica",
        dates = "1225 - 1274 d.C.",
        imageId = R.drawable.ic_launcher_background, // **Reemplazar con tu recurso**
        shortSummary = "Máximo exponente de la Escolástica. Fusionó el aristotelismo con la teología cristiana. Formuló las 'Cinco Vías'.",
        fullBiography = "Texto completo de la biografía y pensamiento..."
    )
    // Agrega más filósofos aquí...
)

@Preview
@Composable
fun TimeLine(){

    Column {
        TimelineNode(
            medievalPhilosophers.get(0)
        )
        TimelineNode(
            medievalPhilosophers.get(1)
        )
        TimelineNode(
            medievalPhilosophers.get(2)
        )
    }


}

@Composable
fun TimelineNode(philosopher: PhilosopherModel) {
    // Estado para controlar la expansión de la tarjeta
    var isExpanded by remember { mutableStateOf(false) }

    // Animación de escala para el punto del filósofo al tocar
    val animatedScale by animateFloatAsState(
        targetValue = if (isExpanded) 1.2f else 1.0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    // El Row contiene la línea central y la tarjeta a un lado
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max), // Permite que la BoxWithConstraints ajuste la altura
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 1. Columna de la Línea de Tiempo (Eje Central)
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(60.dp), // Ancho fijo para el eje
            contentAlignment = Alignment.TopCenter
        ) {
            // Dibuja la línea central
            Canvas(Modifier.fillMaxHeight()) {
                drawLine(
                    color = Color.Black, // Color de la línea
                    start = Offset(x = size.width / 2, y = 0f),
                    end = Offset(x = size.width / 2, y = size.height + 16.dp.toPx()),
                    strokeWidth = 2.dp.toPx()
                )
            }

            // Punto/Nodo del Filósofo (Imagen y animación)
            Image(
                painter = painterResource(id = philosopher.imageId),
                contentDescription = philosopher.name,
                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .scale(animatedScale)
                    .clip(CircleShape)
                    .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .background(Color.White)
                    .clickable { isExpanded = !isExpanded } // Al hacer clic se expande/contrae
            )
        }

        Spacer(Modifier.width(8.dp))

        // 2. Tarjeta de Contenido (A un lado del eje)
        Card(
            modifier = Modifier
                .weight(1f) // Ocupa el espacio restante
                .animateContentSize( // Animación de Compose para cambiar el tamaño de la Card
                    animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
                ),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier
                .padding(16.dp)
                .clickable { isExpanded = !isExpanded } // También expande/contrae al tocar la tarjeta
            ) {
                // Nombre y Fechas (Siempre visibles)
                Text(
                    text = philosopher.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = philosopher.dates,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(Modifier.height(4.dp))

                // Período (Hito/Contexto)
                AssistChip(
                    onClick = { /* Acción de filtro o navegación por período */ },
                    label = { Text(philosopher.period) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        labelColor = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                )

                // Resumen (Solo visible si está expandido)
                if (isExpanded) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = philosopher.shortSummary,
                        style = MaterialTheme.typography.bodyMedium,
                        // Un toque sutil para el usuario
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { /* Navegar a la pantalla de detalle */ }) {
                        Text("Explorar Pensamiento")
                    }
                }
            }
        }
    }
}

@Preview
// Opcional: Un nodo simple para marcar el final de la línea de tiempo
@Composable
fun FinalNode() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(60.dp),
            contentAlignment = Alignment.Center
        ) {
            // Un círculo final sólido
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
        Text("Fin de la Cronología Medieval", modifier = Modifier.padding(start = 16.dp))
    }
}