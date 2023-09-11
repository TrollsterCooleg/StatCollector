package me.cooleg.statcollector.hooks;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.EntitySelectorArgument;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import me.cooleg.statcollector.statisticsmanagement.PlayerStatistics;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommandAPIHook {

    public void registerCommands() {
        new CommandAPICommand("incrementstatistic")
                .withArguments(new EntitySelectorArgument.OnePlayer("target"))
                .withArguments(new GreedyStringArgument("statistic"))
                .withPermission(CommandPermission.OP)
                .executes(((commandSender, commandArguments) -> {
                    Player target = (Player) commandArguments.get("target");
                    String msg = (String) commandArguments.get("statistic");
                    if (target == null || msg == null) {commandSender.sendMessage(ChatColor.RED + "Missing proper arguments!"); return;}

                    PlayerStatistics.getPlayer(target.getUniqueId()).addStatistic(msg, 1);
                })).register();
    }

}
