package by.mksn.miapr

import java.util.*


fun <T> Array<T>.deepEquals(other: Array<T>) = Arrays.deepEquals(this, other)

data class Point(val x: Int, val y: Int) {
    fun distanceTo(p: Point): Double = distanceTo(p.x, p.y)
    fun distanceTo(x: Int, y: Int): Double = Math.hypot((this.x - x).toDouble(), (this.y - y).toDouble())
}

data class VoronoiCluster(val site: Point, val points: Array<Point>)

/**
 * Calculates the center of mass for a given point array
 *
 * @param points array of points
 * @return point that is the center of mass
 */
fun centerOfMass(points: Array<Point>): Point {
    var centerX: Double = 0.0
    var centerY: Double = 0.0
    for (point in points) {
        centerX += point.x
        centerY += point.y
    }
    centerX /= points.size
    centerY /= points.size

    return Point(centerX.toInt(), centerY.toInt())
}

/**
 * Splits all points for clusters in base of specified sites
 *
 * @param points array of all points
 * @param sites array sites for clusters
 */
fun splitForVoronoiClusters(points: Array<Point>, sites: Array<Point>): Array<VoronoiCluster> {
    val clusters = Array<MutableList<Point>>(sites.size, { mutableListOf<Point>() })
    for (point in points) {
        var n = 0
        for (i in 0..sites.lastIndex) {
            if (sites[i].distanceTo(point) < sites[n].distanceTo(point)) {
                n = i
            }
        }
        clusters[n].add(point)
    }
    return Array(sites.size, { index ->
        VoronoiCluster(sites[index], clusters[index].toTypedArray())
    })
}