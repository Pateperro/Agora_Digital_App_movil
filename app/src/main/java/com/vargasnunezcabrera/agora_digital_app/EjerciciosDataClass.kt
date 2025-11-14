package com.vargasnunezcabrera.agora_digital_app

data class Ejercicio(
    val id: Int,
    val pregunta: String,
    val opciones: List<String>
)

object EjerciciosData {
    val listaEjercicios = listOf(
        Ejercicio(
            id = 1,
            pregunta = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit ante...",
            opciones = listOf(
                "Lorem ipsum dolor sit amet",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "Consectetur in orci",
                "Lorem ipsum dolor sit amet"
            )
        )
    )
}
