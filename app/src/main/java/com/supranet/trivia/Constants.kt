package com.supranet.trivia

object Constants {
    val TOTAL_QUESTIONS: String = "total_questions"
    val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // Función para barajar respuestas y devolver el índice de la respuesta correcta
        fun shuffleAnswers(correctAnswer: String, otherAnswers: List<String>): Pair<ArrayList<String>, Int> {
            val answers = ArrayList(otherAnswers)
            answers.add(correctAnswer)
            answers.shuffle()
            val correctAnswerIndex = answers.indexOf(correctAnswer)
            return Pair(answers, correctAnswerIndex)
        }

        // Lista de preguntas y respuestas correctas
        val questionsData = listOf(
            "¿Cuál es el nombre del primer exoplaneta descubierto alrededor de una estrella similar al Sol?" to Pair("51 Pegasi b", listOf("HD 209458 b", "WASP-17b", "Kepler-22b")),
            "¿Qué elemento es el más abundante en el universo?" to Pair("Hidrógeno", listOf("Oxígeno", "Helio", "Carbono-12")),
            "¿A qué distancia se encuentra el agujero negro supermasivo Sagitario A* en la Vía Láctea?" to Pair("26,000 años luz", listOf("2,000 años luz", "100,000 años luz", "1,000 años luz")),
            "¿Cuál es el límite de Schwarzschild?" to Pair("El horizonte de eventos de un agujero negro", listOf("La distancia de un planeta a su estrella", "El punto de fusión de una estrella", "La órbita de un cometa")),
            "¿Qué galaxia es la más cercana a la Vía Láctea?" to Pair("Galaxia de Andrómeda", listOf("Galaxia del Cuervo", "Galaxia de Sculptor", "Galaxia enana de Sagitario")),
            "¿Cuál es el nombre del satélite natural de Saturno que tiene una atmósfera densa?" to Pair("Titán", listOf("Mimas", "Encélado", "Rea")),
            "¿Qué tipo de estrella es la más común en el universo?" to Pair("Estrella enana roja", listOf("Estrella enana amarilla", "Estrella gigante", "Estrella supergigante")),
            "¿Cuál es la distancia aproximada de Neptuno al Sol en UA?" to Pair("30 UA", listOf("20 UA", "40 UA", "50 UA")),
            "¿A cuántos años luz se encuentra la estrella más cercana, Proxima Centauri?" to Pair("4.24 años luz", listOf("4.6 años luz", "3.5 años luz", "6.1 años luz")),
            "¿Cuál es la temperatura superficial aproximada de la estrella Betelgeuse en grados Kelvin?" to Pair("2,500 K", listOf("3,500 K", "5,000 K", "7,000 K")),
            "¿Qué tipo de galaxia es la Galaxia del Sombrero (M104)?" to Pair("Galaxia lenticular", listOf("Galaxia elíptica", "Galaxia espiral", "Galaxia irregular")),
            "¿Cuál es la distancia en años luz de la nebulosa del Cangrejo?" to Pair("6,500 años luz", listOf("4,000 años luz", "8,000 años luz", "10,000 años luz")),
            "¿Cuál es el tipo de núcleo de un cometa?" to Pair("Gas y polvo", listOf("Helio", "Agua congelada", "Rocas y metales")),
            "¿Cuál es el planeta con la mayor inclinación axial en el sistema solar?" to Pair("Urano", listOf("Venus", "Marte", "Saturno")),
            "¿Qué planeta es conocido por sus enormes tormentas de polvo?" to Pair("Marte", listOf("Júpiter", "Saturno", "Neptuno")),
            "¿Cuál es el período orbital de Venus alrededor del Sol?" to Pair("225 días terrestres", listOf("365 días terrestres", "687 días terrestres", "88 días terrestres")),
            "¿Cuál es la tormenta más grande conocida en el sistema solar?" to Pair("Gran Mancha Roja en Júpiter", listOf("Tormenta de polvo en Marte", "Tormenta de hielo en Saturno", "Tormenta de gas en Neptuno")),
            "¿Cuál es la duración de un año en Neptuno?" to Pair("165 años terrestres", listOf("175 años terrestres", "200 años terrestres", "140 años terrestres")),
            "¿Cuál es la temperatura en la parte superior de la atmósfera de Saturno?" to Pair("-220 °C", listOf("-100 °C", "-180 °C", "-240 °C")),
            "¿Cuál es la duración de un día en Mercurio?" to Pair("58.6 días terrestres", listOf("40 días terrestres", "100 días terrestres", "80 días terrestres")),
            "¿Cuál es la atmósfera principal de Titán, la luna de Saturno?" to Pair("Nitrógeno", listOf("Dióxido de carbono", "Oxígeno", "Hidrógeno")),
            "¿Qué fenómeno se produce en Urano debido a su inclinación extrema?" to Pair("Estaciones de 42 años", listOf("Tormentas permanentes", "Conjunciones frecuentes", "Anillos inestables")),
            "¿Qué planeta tiene una atmósfera compuesta principalmente de hidrógeno y helio?" to Pair("Júpiter", listOf("Mercurio", "Marte", "Venus")),
            "¿Qué planeta tiene la mayor diferencia de temperatura entre el día y la noche?" to Pair("Mercurio", listOf("Venus", "Marte", "Saturno")),
            "¿Cuál es la velocidad de escape en la superficie de la Tierra?" to Pair("11.2 km/s", listOf("9.8 km/s", "7.9 km/s", "12.5 km/s")),
            "¿Qué es un agujero negro supermasivo?" to Pair("Un agujero negro en el centro de una galaxia", listOf("Un agujero negro de tamaño normal en un sistema solar", "Un agujero negro que no tiene influencia gravitacional", "Un agujero negro que se forma de una estrella enana")),
            "¿Cuál es el objeto más grande en el cinturón de asteroides?" to Pair("Ceres", listOf("Vesta", "Palas", "Hygiea")),
            "¿Cuál es el nombre del satélite natural de Plutón?" to Pair("Caronte", listOf("Nix", "Hidra", "Charon")),
            "¿Cuál es la principal diferencia entre un meteoroide, un meteoro y un meteorito?" to Pair("El tamaño", listOf("El lugar donde se encuentra", "La velocidad", "La composición"))
        )

        // Generar preguntas con respuestas aleatorias
        var questionId = 1
        for ((questionText, answers) in questionsData) {
            val (shuffledAnswers, correctIndex) = shuffleAnswers(answers.first, answers.second)
            questionsList.add(Question(questionId, questionText, null, shuffledAnswers, correctIndex))
            questionId++
        }

        return questionsList
    }
}
