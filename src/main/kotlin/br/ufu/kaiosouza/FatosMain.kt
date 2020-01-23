package br.ufu.kaiosouza

import br.ufu.kaiosouza.utils.FatosGenerator
import twitter4j.TwitterFactory

fun main() {
    val fatosParse = FatosGenerator()
    val twitter = TwitterFactory.getSingleton()

    val historicalFact = fatosParse.getRandomFact()
    val tweetStatus = twitter.updateStatus(historicalFact.getTweet())

    println("")
    println("Tweet enviado com sucesso!")
    println(" - Link: twitter.com/${twitter.screenName}/status/$tweetStatus")
    println("")
}