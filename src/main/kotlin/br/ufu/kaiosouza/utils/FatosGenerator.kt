package br.ufu.kaiosouza.utils

import br.ufu.kaiosouza.models.HistoricalFact
import org.jsoup.Jsoup
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*
import kotlin.collections.ArrayList


class FatosGenerator {

    fun getRandomFact(): HistoricalFact {
        val rand = Random()
        val historicalFacts = generateRandomFacts()
        return historicalFacts[rand.nextInt(historicalFacts.size)]
    }

    private fun generateRandomFacts(): ArrayList<HistoricalFact> {
        //Pegando emprestado os fatos historicos do site da history <3
        val doc = Jsoup.connect("https://br.historyplay.tv/hoje-na-historia/${getCurrentDateFormated()}").timeout(5000)
        val facts = doc.get().getElementsByClass("block-opacable hstBlock ")

        val historicalFacts = ArrayList<HistoricalFact>()

        for (element in facts) {
            val date = element.getElementsByClass("hstBlock__category").text()
            val fact = element.getElementsByClass("hstBlock__title").text()

            historicalFacts.add(HistoricalFact(convertHistoricalDate(date), fact))
        }

        return historicalFacts
    }

    private fun getCurrentDateFormated(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return LocalDate.now().format(formatter)
    }

    private fun convertHistoricalDate(date: String): LocalDate {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MMM.yyyy"))
    }

}