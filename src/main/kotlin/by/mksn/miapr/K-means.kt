package by.mksn.miapr

import java.util.*

fun <T> Array<T>.deepEquals(other: Array<T>) = Arrays.deepEquals(this, other)

data class Point2D(val x: Int, val y: Int)

data class VoronoiCluster(val site: Point2D, val points: Array<Point2D>)

/**
 * Function to calculate the center of mass for a given point array
 *
 * @param points array of points
 * @return point that is the center of mass
 */
fun centerOfMass(points: Array<Point2D>): Point2D {
    var centerX: Double = 0.0
    var centerY: Double = 0.0
    for (point in points) {
        centerX += point.x
        centerY += point.y
    }
    centerX /= points.size
    centerY /= points.size

    return Point2D(centerX.toInt(), centerY.toInt())
}

