package me.cooleg.statcollector.commands;

import me.cooleg.statcollector.statisticsmanagement.CollectStatistics;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SaveToFile implements CommandExecutor {

    private final JavaPlugin plugin;

    public SaveToFile(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ChatColor.GREEN + "Attempting to save and wipe statistics.");
        CollectStatistics.collectStatistics(plugin);
        return true;
    }
}
