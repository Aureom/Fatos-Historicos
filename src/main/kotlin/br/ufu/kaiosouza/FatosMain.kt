package br.ufu.kaiosouza

import br.ufu.kaiosouza.utils.FatosGenerator
import twitter4j.TwitterFactory

fun main() {
    val fatosParse = FatosGenerator()
    val twitter = TwitterFactory.getSingleton()

    val historicalFact = fatosParse.getRandomFact()
    twitter.updateStatus(historicalFact.getTweet())

    println("Tweet enviado com sucesso!")
}