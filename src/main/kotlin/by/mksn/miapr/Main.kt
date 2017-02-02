import by.mksn.miapr.*
import java.io.File
import java.util.*
import javax.imageio.ImageIO

const val IMAGE_SIZE = 1000

fun main(args: Array<String>) {
    val random = Random()
    val pointCount = 100000
    val clusterCount = 15
    val points = Array<Point>(pointCount, {
        index ->
        Point(random.nextInt(IMAGE_SIZE), random.nextInt(IMAGE_SIZE))
    })
    var sites = Array<Point>(clusterCount, {
        index ->
        Point(random.nextInt(IMAGE_SIZE), random.nextInt(IMAGE_SIZE))
    })
    val colors = Array<Int>(clusterCount, { i -> random.nextInt(16777215) })
    var clusters: Array<VoronoiCluster>
    var i = 0
    do {
        i++
        val oldSites = sites
        clusters = splitForVoronoiClusters(points, oldSites)
        sites = Array<Point>(oldSites.size, { index -> centerOfMass(clusters[index].points) })
    } while (!oldSites.deepEquals(sites) && i < 100)
    val image = drawClustersOnImage(IMAGE_SIZE, colors, clusters)
    ImageIO.write(image, "png", File("k-means-${System.currentTimeMillis()}.png"))
}