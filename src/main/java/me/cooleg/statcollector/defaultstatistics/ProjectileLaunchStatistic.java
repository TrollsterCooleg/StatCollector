package me.cooleg.statcollector.defaultstatistics;

import me.cooleg.statcollector.statisticsmanagement.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.ProjectileSource;

public class ProjectileLaunchStatistic implements Statistic {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void launchProjectiles(ProjectileLaunchEvent event) {
        ProjectileSource source = event.getEntity().getShooter();
        if (!(source instanceof Player player)) {return;}
        incrementStatistic(player.getUniqueId());
    }

    @Override
    public String getName() {
        return "Projectile Launches";
    }
}
