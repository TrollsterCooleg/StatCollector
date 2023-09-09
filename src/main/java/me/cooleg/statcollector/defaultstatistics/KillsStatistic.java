package me.cooleg.statcollector.defaultstatistics;

import me.cooleg.statcollector.statisticsmanagement.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillsStatistic implements Statistic {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void playerKillEvent(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        if (killer == null) {return;}
        incrementStatistic(killer.getUniqueId());
    }

    @Override
    public String getName() {
        return "Player Kills";
    }

}
