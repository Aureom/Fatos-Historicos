package br.ufu.kaiosouza.models

import twitter4j.StatusUpdate
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

data class HistoricalFact(var date: LocalDate, var fact: String) {
    init {
        println("Novo fato historico criado: \n - Data: $date\n - Fato: $fact")
    }

    fun getTweet(): StatusUpdate{
        return StatusUpdate("Nesse mesmo dia em ${date.year} \n \n$fact")
    }
}

/*private fun formatHistoryDate(date: LocalDate): String {
    return "${date.dayOfMonth} de ${date.month.getDisplayName(TextStyle.FULL, Locale("pt", "BR"))} de ${date.year}"
}*/