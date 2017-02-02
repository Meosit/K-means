import by.mksn.miapr.Point2D
import java.util.*

const val IMAGE_SIZE = 500

fun main(args: Array<String>) {
    val random = Random()
    val pointCount = random.nextInt(99001) + 1000
    val clusterCount = random.nextInt(19) + 2
    val points = Array<Point2D>(pointCount, {
        index ->
        Point2D(random.nextInt(IMAGE_SIZE), random.nextInt(IMAGE_SIZE))
    })
    val sites = Array<Point2D>(clusterCount, {
        index ->
        points[random.nextInt(pointCount)]
    })
}