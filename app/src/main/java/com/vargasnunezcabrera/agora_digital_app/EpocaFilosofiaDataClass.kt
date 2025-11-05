package com.vargasnunezcabrera.agora_digital_app

data class EventoHistorico(
    val titulo: String,
    val fecha: String,
    val descripcionCorta: String,
    val descripcionDetallada: String,
    val imagen: Int
)

data class EpocaDetalle(
    val id: String,
    val nombre: String,
    val descripcion: String,
    val imagenPrincipal: Int,
    val eventos: List<EventoHistorico>
)

object EpocasRepository {
    val epocas = listOf(
        EpocaDetalle(
            id = "an",
            nombre = "Filosofía Antigua",
            descripcion = "Surge en Grecia con Sócrates, Platón y Aristóteles...",
            imagenPrincipal = R.drawable.historia_filosofia,
            eventos = listOf(
                EventoHistorico(
                    titulo = "Sócrates y el método mayéutico",
                    fecha = "Siglo V a.C.",
                    descripcionCorta = "Desarrolla el diálogo como herramienta de reflexión.",
                    descripcionDetallada = "Sócrates propone que el conocimiento surge del diálogo interior...",
                    imagen = R.drawable.nietzsche_famosos
                ),
                EventoHistorico(
                    titulo = "Platón funda la Academia",
                    fecha = "387 a.C.",
                    descripcionCorta = "Primera institución filosófica de occidente.",
                    descripcionDetallada = "Platón funda la Academia en Atenas, donde enseña filosofía...",
                    imagen = R.drawable.sigloxix
                )
            )
        ),
        EpocaDetalle(
            id = "me",
            nombre = "Filosofía Medieval",
            descripcion = "Basada en la relación entre fe y razón durante la Edad Media.",
            imagenPrincipal = R.drawable.filosofia_medieval,
            eventos = listOf(
                EventoHistorico(
                    titulo = "Sócrates y el método mayéutico",
                    fecha = "Siglo V a.C.",
                    descripcionCorta = "Desarrolla el diálogo como herramienta de reflexión.",
                    descripcionDetallada = "Sócrates propone que el conocimiento surge del diálogo interior...",
                    imagen = R.drawable.estudio
                ), EventoHistorico(
                    titulo = "Sócrates y el método mayéutico",
                    fecha = "Siglo V a.C.",
                    descripcionCorta = "Desarrolla el diálogo como herramienta de reflexión.",
                    descripcionDetallada = "Sócrates propone que el conocimiento surge del diálogo interior...",
                    imagen = R.drawable.filosofiamoderna
            )
            )
        )
    )

    fun getEpocaById(id: String): EpocaDetalle? { // obtener el detalle de cada epoca por Id, si no encuentra nada retorna null gracias al ?
        return epocas.find { it.id == id }
    }
}
