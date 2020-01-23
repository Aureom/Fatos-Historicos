package br.ufu.kaiosouza.models

import twitter4j.StatusUpdate
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class HistoricalFact(var date: LocalDate, var fact: String) {
    init {
        println("Novo fato historico criado: \n - Data: $date\n - Fato: $fact")
    }

    private fun getDaysElapsed(): Long {
        return ChronoUnit.DAYS.between(date, LocalDate.now())
    }

    fun getTweet(): StatusUpdate{
        return StatusUpdate("Há ${getDaysElapsed()} dias atrás, nessa mesma data em ${date.year}: $fact")
    }
}