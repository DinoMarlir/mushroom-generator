package de.hglabor.mushroomgenerator.listener

import de.hglabor.mushroomgenerator.config.YamlConfigManager
import de.hglabor.mushroomgenerator.util.randomBlock
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.world.ChunkLoadEvent
import java.util.Random

class ChunkLoadListener : Listener {

    val random = Random()
    val mushrooms = listOf(Material.RED_MUSHROOM, Material.BROWN_MUSHROOM)

    @EventHandler
    fun onChunkLoad(event: ChunkLoadEvent) {
        if(!event.isNewChunk) {
            return
        }
        repeat(YamlConfigManager.maxMushroomsPerChunk) { _ ->
            if(random.nextDouble() <= YamlConfigManager.mushroomChance) {
                val it = event.chunk.randomBlock.location.clone().add(0.0, 1.0, 0.0).block
                kotlin.runCatching {
                    if(it.type != Material.WATER && it.type != Material.STATIONARY_WATER && it.type != Material.LAVA && it.type != Material.STATIONARY_LAVA) {
                        it.setType(mushrooms.random(), false)
                    }
                }
            }
        }
    }
}