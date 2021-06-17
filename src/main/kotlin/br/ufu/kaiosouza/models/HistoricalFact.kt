package br.ufu.kaiosouza.models

import twitter4j.StatusUpdate
import java.net.URL
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class HistoricalFact(var date: LocalDate, var fact: String, var imageURL: String) {
    init {
        println("Novo fato historico criado: \n - Data: $date\n - Fato: $fact")
    }

    private fun getYearsElapsed(): Long {
        return ChronoUnit.YEARS.between(date, LocalDate.now())
    }

    fun getTweetText(): String{
        return "Há ${getYearsElapsed()} anos atrás, nessa mesma data em ${date.year}: $fact"
    }
}