package com.vargasnunezcabrera.agora_digital_app

import com.vargasnunezcabrera.agora_digital_app.R

data class Filosofo(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val image: Int,
    val historia: String,
    var notas: String = ""
)

object FilosofoData {
    val listaFilosofos = listOf(
        Filosofo(
            id = 1,
            nombre = "Sócrates",
            descripcion = "Filósofo griego considerado el padre de la ética y la filosofía moral.",
            image = R.drawable.socrates_dos,
            historia = "Sócrates (470–399 a.C.) fue un filósofo ateniense conocido por su método de diálogo, "
                    + "llamado la mayéutica. No dejó obras escritas, por lo que su pensamiento es conocido a través "
                    + "de Platón y Jenofonte. Su filosofía se centró en la búsqueda del conocimiento propio y la virtud. "
                    + "Fue condenado a muerte por impiedad y corromper a la juventud."
        ),
        Filosofo(
            id = 2,
            nombre = "Platón",
            descripcion = "Discípulo de Sócrates y fundador de la Academia de Atenas.",
            image = R.drawable.platon,
            historia = "Platón (427–347 a.C.) fue un filósofo griego que desarrolló la teoría de las Ideas, "
                    + "según la cual el mundo sensible es una copia imperfecta del mundo ideal. Fundó la Academia, "
                    + "una de las primeras instituciones de educación superior en Occidente. Sus diálogos son la base "
                    + "de gran parte de la filosofía occidental."
        ),
        Filosofo(
            id = 3,
            nombre = "Aristóteles",
            descripcion = "Filósofo griego, alumno de Platón y maestro de Alejandro Magno.",
            image = R.drawable.aristoteles,
            historia = "Aristóteles (384–322 a.C.) fue uno de los pensadores más influyentes de la historia. "
                    + "Fundó el Liceo y escribió sobre lógica, ética, metafísica, política, biología y retórica. "
                    + "Desarrolló la lógica formal y la idea de la virtud como punto medio. Su obra dominó el "
                    + "pensamiento occidental durante siglos."
        ),
        Filosofo(
            id = 4,
            nombre = "René Descartes",
            descripcion = "Filósofo racionalista francés, padre de la filosofía moderna.",
            image = R.drawable.descartes,
            historia = "René Descartes (1596–1650) fue un filósofo, matemático y científico francés. "
                    + "Es conocido por su frase 'Cogito, ergo sum' (Pienso, luego existo). Propuso el racionalismo "
                    + "como camino hacia el conocimiento y desarrolló la geometría analítica. Su pensamiento marcó el "
                    + "inicio de la filosofía moderna."
        ),
        Filosofo(
            id = 5,
            nombre = "Friedrich Nietzsche",
            descripcion = "Filósofo alemán crítico de la moral tradicional y la cultura occidental.",
            image = R.drawable.nietzsche,
            historia = "Friedrich Nietzsche (1844–1900) fue un filósofo alemán cuyo pensamiento critica la moral "
                    + "cristiana, la sociedad moderna y los sistemas filosóficos tradicionales. Introdujo conceptos como "
                    + "el superhombre, la voluntad de poder y la muerte de Dios. Su obra influyó profundamente en la "
                    + "filosofía contemporánea."
        )
    )
}
