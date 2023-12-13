package me.cooleg.statcollector.commands;

import me.cooleg.statcollector.statisticsmanagement.PlayerStatistics;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class ToggleCollecting implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        boolean collecting;
        if (strings.length > 0) {
            String string = strings[0];
            collecting = Boolean.parseBoolean(string);
        } else {
            collecting = !PlayerStatistics.getCollecting();
        }

        PlayerStatistics.setCollecting(collecting);
        commandSender.sendMessage(ChatColor.GREEN + "Set collecting to " + collecting);
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 1) {
            return List.of("true", "false");
        }

        return Collections.emptyList();
    }
}
