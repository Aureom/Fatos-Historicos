package br.ufu.kaiosouza

import br.ufu.kaiosouza.models.HistoricalFact
import br.ufu.kaiosouza.utils.FatosGenerator
import twitter4j.StatusUpdate
import twitter4j.TwitterFactory

fun main() {
    val fatosParse = FatosGenerator();
    val twitter = TwitterFactory.getSingleton()

    val historicalFact = fatosParse.getRandomFact()

    val status = twitter.updateStatus(historicalFact.getTweet())
}