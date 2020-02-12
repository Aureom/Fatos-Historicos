package br.ufu.kaiosouza.utils

import br.ufu.kaiosouza.models.HistoricalFact
import org.jsoup.Jsoup
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*
import kotlin.collections.ArrayList


class FatosGenerator {

    fun getRandomFact(): HistoricalFact {
        val rand = Random()
        val historicalFacts = generateRandomFacts()
        return historicalFacts[rand.nextInt(historicalFacts.size)]
    }

    private fun generateRandomFacts(): ArrayList<HistoricalFact> {
        val doc = Jsoup.connect("https://br.historyplay.tv/hoje-na-historia/${getCurrentDateFormated()}").timeout(5000) //pegando emprestado os fatos historicos do site da history <3
        val facts = doc.get().getElementsByClass("block-opacable hstBlock ")

        val historicalFacts = ArrayList<HistoricalFact>()

        for (element in facts) { //percorendo todos os fatos historicos desse dia
            val date = element.getElementsByClass("hstBlock__category").text()
            val fact = element.getElementsByClass("hstBlock__title").text()

            historicalFacts.add(HistoricalFact(convertHistoricalDate(date), fact)) //pegando emprestado um fato historico
        }

        return historicalFacts
    }

    private fun getCurrentDateFormated(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return LocalDate.now().format(formatter)
    }

    private fun convertHistoricalDate(date: String): LocalDate {
        val formatter = DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd.MMM.yyyy").toFormatter().withLocale(Locale("pt", "BR"))
        return LocalDate.parse(date, formatter)
    }

}