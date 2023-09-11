package me.cooleg.statcollector.statisticsmanagement;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PropertyManager {

    private final JavaPlugin plugin;

    public PropertyManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public Property registerProperty(String property) {
        Bukkit.getLogger().info("Custom property " + property + " registered by plugin " + plugin.getName());
        return new Property(property, plugin);
    }

    public void setProperty(Player player, Property property, String value) {
        if (property.getPlugin() != plugin) {throw new RuntimeException("Plugin is setting a StatCollector property not registered by it!");}
        PlayerStatistics.getPlayer(player.getUniqueId()).setProperty(property.getName(), value);
    }

    public String getProperty(Player player, Property property) {
        if (property.getPlugin() != plugin) {throw new RuntimeException("Plugin is setting a StatCollector property not registered by it!");}
        return PlayerStatistics.getPlayer(player.getUniqueId()).getProperty(property.getName());
    }

}
