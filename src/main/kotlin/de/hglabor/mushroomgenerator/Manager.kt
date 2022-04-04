package de.hglabor.mushroomgenerator

import de.hglabor.mushroomgenerator.config.YamlConfigManager
import de.hglabor.mushroomgenerator.listener.ChunkLoadListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Manager : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: Manager; private set
    }

    override fun onEnable() {
        INSTANCE = this
        YamlConfigManager
        Bukkit.getPluginManager().registerEvents(ChunkLoadListener(), INSTANCE)
        println(YamlConfigManager.mushroomChance)
        println(YamlConfigManager.mushroomChance)
        println(YamlConfigManager.mushroomChance)
        println(YamlConfigManager.mushroomChance)
        println(YamlConfigManager.mushroomChance)
        println(YamlConfigManager.mushroomChance)
        println(YamlConfigManager.mushroomChance)
    }

}