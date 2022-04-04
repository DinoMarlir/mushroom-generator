package de.hglabor.mushroomgenerator.util

import org.bukkit.Chunk
import org.bukkit.Material
import org.bukkit.block.Block
import java.util.Random

val random = Random()

val Chunk.randomBlock: Block
    get() {
        val x = random.nextInt(16)-random.nextInt(16)
        val z = random.nextInt(16)-random.nextInt(16)
        val y = highestValidBlockAt(x, z)
        return getBlock(x, y.toInt(), z)
    }

fun Chunk.highestValidBlockAt(x: Int, z: Int): Double {
    var y = 254.0
    repeat(180) { cY ->
        val it = getBlock(x, cY, z)
        if (it.type == Material.SNOW_BLOCK || it.type == Material.MYCEL || it.type == Material.DIRT || it.type == Material.GRASS || it.type == Material.LONG_GRASS || it.type == Material.STONE) {
            y = cY.toDouble()
        }
    }
    return y
}