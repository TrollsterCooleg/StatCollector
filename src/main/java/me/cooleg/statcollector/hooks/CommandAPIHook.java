package me.cooleg.statcollector.hooks;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.EntitySelectorArgument;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import dev.jorel.commandapi.arguments.ObjectiveArgument;
import me.cooleg.statcollector.statisticsmanagement.PlayerStatistics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;

public class CommandAPIHook {

    public void registerCommands() {
        new CommandAPICommand("incrementstatistic")
                .withArguments(new EntitySelectorArgument.OnePlayer("target"))
                .withArguments(new GreedyStringArgument("statistic"))
                .withPermission(CommandPermission.OP)
                .executes(((commandSender, commandArguments) -> {
                    Player target = (Player) commandArguments.get("target");
                    String stat = (String) commandArguments.get("statistic");
                    if (target == null || stat == null) {commandSender.sendMessage(ChatColor.RED + "Missing proper arguments!"); return;}

                    PlayerStatistics.getPlayer(target.getUniqueId()).addStatistic(stat, 1);
                })).register();

        new CommandAPICommand("getfromobjective")
                .withArguments(new ObjectiveArgument("objective"))
                .withArguments(new GreedyStringArgument("statistic"))
                .withPermission(CommandPermission.OP)
                .executes(((commandSender, commandArguments) -> {
                    Objective objective = (Objective) commandArguments.get("objective");
                    String stat = (String) commandArguments.get("statistic");

                    for (Player p : Bukkit.getOnlinePlayers()) {
                        int score = objective.getScore(p.getName()).getScore();
                        PlayerStatistics.getPlayer(p.getUniqueId()).setStatistic(stat, score);
                    }
                })).register();
    }

}
