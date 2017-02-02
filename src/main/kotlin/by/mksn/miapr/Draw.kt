package by.mksn.miapr

import java.awt.Color
import java.awt.geom.Ellipse2D
import java.awt.image.BufferedImage

fun drawClustersOnImage(imageSize: Int, colors: Array<Int>, clusters: Array<VoronoiCluster>): BufferedImage {
    val image = BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB)
    val graphics = image.createGraphics()

    graphics.background = Color.WHITE
    graphics.clearRect(0, 0, imageSize, imageSize)
    clusters.forEachIndexed { i, cluster ->
        cluster.points.forEach {
            graphics.color = Color(colors[i])
            val ellipse = Ellipse2D.Double((it.x - 2).toDouble(), (it.y - 2).toDouble(), 4.0, 4.0)
            graphics.fill(ellipse)
        }
        graphics.color = Color.BLACK
        val ellipse = Ellipse2D.Double((cluster.site.x - 4).toDouble(), (cluster.site.y - 4).toDouble(), 8.0, 8.0)
        graphics.fill(ellipse)
    }
    graphics.dispose()
    return image
}
