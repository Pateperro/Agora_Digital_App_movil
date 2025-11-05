package com.vargasnunezcabrera.agora_digital_app

data class EventoHistorico(
    val titulo: String,
    val fecha: String,
    val descripcionCorta: String,
    val descripcionDetallada: String,
    val imagen: Int
)

data class EpocaDetalle(
    val nombre: String,
    val descripcion: String,
    val imagenPrincipal: Int,
    val eventos: List<EventoHistorico>
)

object EpocasRepository {
    val epocas = listOf(
        EpocaDetalle(
            nombre = "Filosofía Antigua",
            descripcion = "Surge en Grecia con Sócrates, Platón y Aristóteles...",
            imagenPrincipal = 5,
            eventos = listOf(
                EventoHistorico(
                    titulo = "Sócrates y el método mayéutico",
                    fecha = "Siglo V a.C.",
                    descripcionCorta = "Desarrolla el diálogo como herramienta de reflexión.",
                    descripcionDetallada = "Sócrates propone que el conocimiento surge del diálogo interior...",
                    imagen = 8
                ),
                EventoHistorico(
                    titulo = "Platón funda la Academia",
                    fecha = "387 a.C.",
                    descripcionCorta = "Primera institución filosófica de occidente.",
                    descripcionDetallada = "Platón funda la Academia en Atenas, donde enseña filosofía...",
                    imagen = 7
                )
            )
        ),
        EpocaDetalle(
            nombre = "",
            descripcion = "",
            imagenPrincipal = 5,
            eventos = listOf(
                EventoHistorico(
                    titulo = "Sócrates y el método mayéutico",
                    fecha = "Siglo V a.C.",
                    descripcionCorta = "Desarrolla el diálogo como herramienta de reflexión.",
                    descripcionDetallada = "Sócrates propone que el conocimiento surge del diálogo interior...",
                    imagen = 8
                ), EventoHistorico(
                    titulo = "Sócrates y el método mayéutico",
                    fecha = "Siglo V a.C.",
                    descripcionCorta = "Desarrolla el diálogo como herramienta de reflexión.",
                    descripcionDetallada = "Sócrates propone que el conocimiento surge del diálogo interior...",
                    imagen = 8
            )
            )
        )
    )

    fun getEpocaByNombre(nombre: String): EpocaDetalle? { // obtener el detalle de cada epoca por nombre, si no encuentra nada retorna null gracias al ?
        return epocas.find { it.nombre == nombre }
    }
}
