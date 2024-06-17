package me.cooleg.statcollector;

import me.cooleg.statcollector.statisticsmanagement.CollectStatistics;
import me.cooleg.statcollector.statisticsmanagement.PlayerStatistics;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginStateManager {

    private static JavaPlugin plugin;

    public static void saveStats() {
        CollectStatistics.collectStatistics(plugin);
    }

    public static void wipeStats() {
        PlayerStatistics.clearStatistics();
    }

    public static void saveStatsAndWipe() {
        CollectStatistics.collectStatistics(plugin);
        PlayerStatistics.clearStatistics();
    }

    public static boolean getCollecting() {
        return PlayerStatistics.getCollecting();
    }

    public static void setCollecting(boolean collect) {
        PlayerStatistics.setCollecting(collect);
    }

    public static void initializeManager(JavaPlugin javaPlugin) {
        plugin = javaPlugin;
    }

}
