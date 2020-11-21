package br.ufu.kaiosouza

import br.ufu.kaiosouza.managers.TwitterManager
import br.ufu.kaiosouza.utils.FatosGenerator
import twitter4j.TwitterFactory

fun main() {
    val factsParse = FatosGenerator()
    val twitterManager = TwitterManager()

    twitterManager.tweetFact(factsParse)

    println("Tweet enviado com sucesso!")
}