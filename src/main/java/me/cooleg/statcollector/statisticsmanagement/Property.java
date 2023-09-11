package me.cooleg.statcollector.statisticsmanagement;

import org.bukkit.plugin.java.JavaPlugin;

public class Property {

    private final String name;
    private final JavaPlugin plugin;

    public Property(String name, JavaPlugin plugin) {
        this.name = name;
        this.plugin = plugin;
    }

    public String getName() {
        return name;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    @Override
    public String toString() {
        return name;
    }
}
