package by.mksn.miapr

import java.io.File
import java.util.*
import javax.imageio.ImageIO

const val IMAGE_SIZE = 1000

private val RANDOM = Random()

fun randomInt(bound: Int = Int.MAX_VALUE) = RANDOM.nextInt(bound)

fun main(args: Array<String>) {
    val pointCount = 90000
    val clusterCount = 9
    val points = Array<Point>(pointCount, {
        index ->
        Point(randomInt(IMAGE_SIZE), randomInt(IMAGE_SIZE))
    })
    val sites = Array<Point>(clusterCount, {
        index ->
        Point(randomInt(IMAGE_SIZE), randomInt(IMAGE_SIZE))
    })
    val clusters = clusterByKMeans(points, sites)
    val image = drawClustersOnImage(IMAGE_SIZE, clusters)
    ImageIO.write(image, "png", File("k-means-${System.currentTimeMillis()}.png"))
}
