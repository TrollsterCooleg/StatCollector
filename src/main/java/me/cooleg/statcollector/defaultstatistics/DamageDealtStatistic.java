package me.cooleg.statcollector.defaultstatistics;

import me.cooleg.statcollector.statisticsmanagement.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageDealtStatistic implements Statistic {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void damageDeal(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            addStatistic(player.getUniqueId(), event.getFinalDamage());
        } else if (event.getDamager() instanceof Projectile projectile) {
            if (!(projectile.getShooter() instanceof Player player)) {return;}
            addStatistic(player.getUniqueId(), event.getFinalDamage());
        }
    }


    @Override
    public String getName() {
        return "Damage Dealt";
    }
}
