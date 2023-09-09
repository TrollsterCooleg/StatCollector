package me.cooleg.statcollector.commands;

import me.cooleg.statcollector.statisticsmanagement.PlayerStatistics;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleCollecting implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        boolean collecting = !PlayerStatistics.getCollecting();
        PlayerStatistics.setCollecting(collecting);
        commandSender.sendMessage(ChatColor.GREEN + "Set collecting to " + collecting);
        return false;
    }
}
