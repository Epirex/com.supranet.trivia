package com.supranet.trivia

object Constants {
    val TOTAL_QUESTIONS: String = "total_questions"
    val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        fun shuffleAnswers(correctAnswer: String, otherAnswers: List<String>): Pair<ArrayList<String>, Int> {
            val answers = ArrayList(otherAnswers)
            answers.add(correctAnswer)
            answers.shuffle()
            val correctAnswerIndex = answers.indexOf(correctAnswer)
            return Pair(answers, correctAnswerIndex)
        }

        val questionsData = listOf(
            "¿Qué significa CAMYEN?" to Pair("Catamarca Minera y Energética", listOf("Cámara de Minería y Energía", "Catamarca Mujeres y Energia", "Cámara de Mineras Energéticas")),
            "¿Cuál es la piedra nacional de Argentina?" to Pair("Rodocrosita", listOf("Amatista", "Ceibo", "Esmeralda")),
            "¿Cuándo se fundó CAMYEN?" to Pair("2012", listOf("1995", "2001", "2021")),
            "CAMYEN tiene prioridad para adquirir minas caducas y vacantes nuevas propiedades mineras. ¿Desde qué año?" to Pair("2021", listOf("1972", "1989", "2010")),
            "¿En qué departamento de la provincia se ubica la mina de rodocrosita que explota CAMYEN?" to Pair("Andalgalá", listOf("Antofagasta de la Sierra", "Tinogasta", "Ninguna de las anteriores")),
            "CAMYEN cuenta con áreas mineras de:" to Pair("Todas las anteriores", listOf("Litio", "Cobre", "Oro", "Molibdeno")),
            "CAMYEN está asociado para la exploracion de litio con:" to Pair("YPF Litio", listOf("Posco", "Livent", "Zijin-Liex")),
            "¿Cuales son las características de las Energías Renovables?" to Pair("Todas son correctas", listOf("No utilizan combustibles fósiles", "No generan emisiones de Dióxido de Carbono (CO2)", "Se obtienen a partir de fuentes naturales virtualmente inagotables como el viento, el sol, o el movimiento del agua")),
            "¿Cuáles son los principales objetivos a los que hoy apunta CAMYEN?" to Pair("Todas son correctas", listOf("Asociarse con inversores privados para impulsar el desarrollo sostenible de los recursos naturales", "Desarrollar mano de obra calificada local", "Promover recursos para la Investigación y el Desarrollo en la provincia")),
            "¿Cuál es la visión de CAMYEN?" to Pair("Tener un rol protagónico en la promoción de la minería y las energías renovables", listOf("Insertarse en otros sectores de la economía, además de la minería y la energía", "Ser el único productor de rodocrosita a nivel mundial", "Diseñar nuevos productos con otros tipos de rocas, además de la rodocrosita.")),
            "¿Cómo es el usuario de Instagram de CAMYEN?" to Pair("@camyenseoficial", listOf("@catamarcamineraenergetica", "@catamarcamyen", "@camyen")),
            "¿Cuántos seguidores tiene CAMYEN en Instagram?" to Pair("3111", listOf("1532", "1874", "1269")),
            "¿Cómo se llama la mina de rodocrosita que explota CAMYEN?" to Pair("Minas Capillitas", listOf("Cerro Atajo", "Farallón Negro", "Refugio del Minero")),
            "¿Cuál es la veta que se explota actualmente en la mina de rodocrosita que explota CAMYEN?" to Pair("Veta Ortiz", listOf("Veta 9 de Julio", "Veta 25 de Mayo", "Todas las anteriores")),
            "¿Con qué otro nombre se conoce a la Rodocrosita?" to Pair("La rosa del Inca", listOf("La piedra del Inca", "La flor de la sangre", "La piedra rosa")),
            "¿En qué etapas se encuentran los proyectos de CAMYEN?" to Pair("Todas son correctas", listOf("En prospección", "En exploración", "En explotación")),
            "CAMYEN trabaja con Y-TEC (YPF Tecnología) para:" to Pair("Fabricar LFP (litio ferro fosfato) en Catamarca", listOf("Explotar yacimientos petrolíferos en Catamarca", "Realizar artesanías y joyas de rodocrosita", "Todas son correctas")),
            "¿Con cuántas áreas mineras distribuidas en la Provincia cuenta CAMYEN?" to Pair("más de 300", listOf("87", "243", "172")),
            "¿Cuál de los siguientes NO es un valor de CAMYEN?" to Pair("Caridad", listOf("Transparencia", "Cuidado del Ambiente", "Consenso Social y Compromiso")),
            "¿Cuántos empleados tiene CAMYEN?" to Pair("Más de 70", listOf("Menos de 50", "50", "Más de 60")),
            "CAMYEN tiene un área donde se puede desarrollar la energía Geotérmica, ¿Dónde se ubica?" to Pair("Cerro Blanco", listOf("Minas Capillitas", "Cortaderas", "Cerro Atajo")),
            "¿Qué mineral se utiliza para la creación de los marcapasos artificiales?" to Pair("Platino y Litio", listOf("Plata y oro", "Cobre y plata", "Litio y Cobre")),
            "¿Cuál de estos elementos se extrae comúnmente de las minas de sal?" to Pair("Todas las anteriores", listOf("Potasio", "Sodio", "Cloro")),
            "¿Cuál es la dirección perteneciente al Ministerio de Minería que controla el cuidado ambiental del aire y agua?" to Pair("Dirección Provincial de Gestión Ambiental", listOf("Dirección Provincial de Minería", "Dirección Policía Minera", "Secretaría de Recursos Naturales")),
            "Para la creación de cosméticos ¿qué minerales se utilizan?" to Pair("Sulfato de potasio, oxido de zinc, oxicloruro de bismuto, dióxido de titanio, cloruro de sodio, litio, oxido de hierro, moscovita (MICA)", listOf("Sulfato de potasio, oxido de zinc, oro, plata, sodio", "Carbonato de calcio, mercurio, plomo, hierro", "Níquel, cobalto, cobre, manganeso")),
            "¿Qué es una gema o piedra preciosa?" to Pair("Mineral roca", listOf("Cobre", "Aleación metálica", "Resina sintética"))
        )

        var questionId = 1
        for ((questionText, answers) in questionsData) {
            val (shuffledAnswers, correctIndex) = shuffleAnswers(answers.first, answers.second)
            questionsList.add(Question(questionId, questionText, null, shuffledAnswers, correctIndex))
            questionId++
        }

        return questionsList
    }
}