package br.ufu.kaiosouza.models

data class HistoricalFact(var dateFormated: String, var fact: String) {
    init {
        println("Novo fato historico criado: \n - Data: $dateFormated\n - Fato: $fact")
    }
}