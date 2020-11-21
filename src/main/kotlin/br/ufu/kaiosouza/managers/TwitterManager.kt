package br.ufu.kaiosouza.managers

import br.ufu.kaiosouza.utils.FatosGenerator
import twitter4j.StatusUpdate
import twitter4j.TwitterFactory
import java.awt.image.BufferedImage
import java.io.File
import java.net.URL
import javax.imageio.ImageIO


class TwitterManager {

    private val twitter = TwitterFactory.getSingleton()

    fun tweetFact(facts: FatosGenerator) {
        val fact = facts.getRandomFact()
        val status = StatusUpdate(fact.getTweetText())

        val url = URL(fact.imageURL)
        val img: BufferedImage = ImageIO.read(url)
        val imgFormat = fact.imageURL.takeLast(3)
        val file = File("fact-image.${imgFormat}")
        ImageIO.write(img, imgFormat, file)

        val media = twitter.uploadMedia(file)

        if(media != null) status.setMediaIds(media.mediaId)

        twitter.updateStatus(status)
    }

}