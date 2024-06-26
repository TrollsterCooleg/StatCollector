package me.cooleg.statcollector.statisticsmanagement;

import me.cooleg.statcollector.StatCollector;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CollectStatistics {

    public static void collectStatistics(JavaPlugin plugin) {
        List<String> statistics = PlayerStatistics.getStatistics().stream().sorted().toList();
        List<String> properties = PlayerStatistics.getProperties().stream().sorted().toList();
        HashMap<UUID, PlayerStatistics> statsMap = PlayerStatistics.getPlayers();

        File file = new File("plugins/StatCollector/stats.csv");

        new BukkitRunnable() {
            @Override
            public void run() {
                file.mkdirs();
                try {
                    if (file.exists()) {file.delete();}
                    file.createNewFile();
                    FileWriter write = new FileWriter(file);
                    write.write("UUID");
                    for (String string : properties) {write.write(","+string);}
                    for (String string : statistics) {write.write("," + string);}
                    write.write('\n');
                    for (Map.Entry<UUID, PlayerStatistics> stats : statsMap.entrySet()) {
                        write.write(stats.getKey().toString());
                        for (String property : properties) {
                            write.write(","+stats.getValue().getProperty(property));
                        }
                        for (String statistic : statistics) {
                            write.write(","+stats.getValue().getStatistic(statistic));
                        }
                        write.write('\n');
                    }
                    write.flush();
                    StatCollector.sendFileToWebhook(file);
                } catch (IOException ex) {
                    Bukkit.getLogger().severe("Couldn't write to csv file.");
                }
            }
        }.runTaskAsynchronously(plugin);
    }
}
