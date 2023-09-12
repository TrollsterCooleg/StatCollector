package me.cooleg.statcollector.defaultstatistics;

import me.cooleg.statcollector.statisticsmanagement.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageTakenStatistic implements Statistic {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void damageTaken(EntityDamageEvent event) {
        // Honestly if someone does take 1 billion damage in one hit without
        // getting /killed I give up they can just not have it count
        if (event.getFinalDamage() > 1000000000) {return;}
        if (!(event.getEntity() instanceof Player player)) {return;}
        addStatistic(player.getUniqueId(), event.getFinalDamage());
    }

    @Override
    public String getName() {
        return "Damage Taken";
    }
}
