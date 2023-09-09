package me.cooleg.statcollector.defaultstatistics;

import me.cooleg.statcollector.statisticsmanagement.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class ProjectileHitStatistic implements Statistic {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void projectileHit(ProjectileHitEvent event) {
        if (!(event.getHitEntity() instanceof Player)) {return;}
        ProjectileSource source = event.getEntity().getShooter();
        if (!(source instanceof Player player)) {return;}
        incrementStatistic(player.getUniqueId());
    }

    @Override
    public String getName() {
        return "Projectile Hits";
    }
}
