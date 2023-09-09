package me.cooleg.statcollector.commands;

import me.cooleg.statcollector.statisticsmanagement.PlayerStatistics;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WipeStats implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ChatColor.GREEN + "Wiping statistics.");
        PlayerStatistics.clearStatistics();
        return true;
    }
}
