package de.hglabor.mushroomgenerator.config

import de.hglabor.mushroomgenerator.Manager
import java.io.File

object YamlConfigManager {

    val file = File(Manager.INSTANCE.dataFolder, "config.yml")

    init {
        if(!file.parentFile.exists()) {
            file.parentFile.mkdir()
        }
        if(!file.exists()) {
            file.createNewFile()
            file.writeText("""
                # mushroom generator plugin by mooziii
                mushrooms:
                  chance: 0.75
                  maxPerChunk: 8
            """.trimIndent())
        }
    }

    val mushroomChance: Double
        get() = Manager.INSTANCE.config.getDouble("mushrooms.chance", 0.75)

    val maxMushroomsPerChunk: Int
        get() = Manager.INSTANCE.config.getInt("mushrooms.maxPerChunk", 8)

}