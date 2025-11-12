package com.vargasnunezcabrera.agora_digital_app

import com.vargasnunezcabrera.agora_digital_app.R

data class Filosofo(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val image: Int,
    val historia: String
)

object FilosofoData {
    val listaFilosofos = listOf(
        Filosofo(
            id = 1,
            nombre = "Sócrates",
            descripcion = "Filósofo griego, considerado padre de la ética.",
            image = R.drawable.socrates_dos,
            historia = "Sócrates (470–399 a.C.) fue un filósofo griego conocido por su método dialéctico..."
        ),
        Filosofo(
            id = 2,
            nombre = "Platón",
            descripcion = "Discípulo de Sócrates y fundador de la Academia.",
            image = R.drawable.platon,
            historia = "Platón (427–347 a.C.) fue un filósofo griego, alumno de Sócrates y maestro de Aristóteles..."
        ),
        Filosofo(
            id = 3,
            nombre = "Aristóteles",
            descripcion = "Filósofo griego, estudiante de Platón y maestro de Alejandro Magno.",
            image = R.drawable.aristoteles,
            historia = "Aristóteles (384–322 a.C.) fue un filósofo griego, contribuyó a la lógica, ética y política..."
        ),
        Filosofo(
            id = 4,
            nombre = "Descartes",
            descripcion = "Filósofo griego, estudiante de Platón y maestro de Alejandro Magno.",
            image = R.drawable.descartes,
            historia = "Aristóteles (384–322 a.C.) fue un filósofo griego, contribuyó a la lógica, ética y política..."
        ),
        Filosofo(
            id = 5,
            nombre = "Nietzsche",
            descripcion = "Filósofo griego, estudiante de Platón y maestro de Alejandro Magno.",
            image = R.drawable.nietzsche,
            historia = "Aristóteles (384–322 a.C.) fue un filósofo griego, contribuyó a la lógica, ética y política..."
        )
    )
}
