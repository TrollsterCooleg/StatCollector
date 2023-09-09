package me.cooleg.statcollector.defaultstatistics;

import me.cooleg.statcollector.statisticsmanagement.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathsStatistic implements Statistic {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onDeath(PlayerDeathEvent event) {
        incrementStatistic(event.getEntity().getUniqueId());
    }

    @Override
    public String getName() {
        return "Player Deaths";
    }
}
