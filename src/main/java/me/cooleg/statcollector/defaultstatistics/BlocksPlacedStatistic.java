package me.cooleg.statcollector.defaultstatistics;

import me.cooleg.statcollector.statisticsmanagement.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlocksPlacedStatistic implements Statistic {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void blockPlaced(BlockPlaceEvent event) {
        incrementStatistic(event.getPlayer().getUniqueId());
    }

    @Override
    public String getName() {
        return "Blocks Placed";
    }
}
