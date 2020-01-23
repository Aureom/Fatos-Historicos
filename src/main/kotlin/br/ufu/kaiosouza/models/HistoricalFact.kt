package br.ufu.kaiosouza.models

import twitter4j.StatusUpdate
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class HistoricalFact(var date: LocalDate, var fact: String) {
    /*init {
        println("Novo fato historico criado: \n - Data: $date\n - Fato: $fact")
    }*/

    private fun getYearsElapsed(): Long {
        return ChronoUnit.YEARS.between(date, LocalDate.now())
    }

    fun getTweet(): StatusUpdate{
        return StatusUpdate("Há ${getYearsElapsed()} anos atrás, nessa mesma data em ${date.year}: $fact")
    }
}