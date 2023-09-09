package me.cooleg.statcollector;

import me.cooleg.statcollector.commands.SaveToFile;
import me.cooleg.statcollector.commands.ToggleCollecting;
import me.cooleg.statcollector.commands.WipeStats;
import me.cooleg.statcollector.defaultstatistics.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class StatCollector extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("savestats").setExecutor(new SaveToFile(this));
        getCommand("togglecollecting").setExecutor(new ToggleCollecting());
        getCommand("wipestats").setExecutor(new WipeStats());
        registerEvents();
    }

    private void registerEvents() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new BlocksBrokenStatistic(), this);
        manager.registerEvents(new BlocksPlacedStatistic(), this);
        manager.registerEvents(new DamageDealtStatistic(), this);
        manager.registerEvents(new DamageTakenStatistic(), this);
        manager.registerEvents(new DeathsStatistic(), this);
        manager.registerEvents(new KillsStatistic(), this);
        manager.registerEvents(new ProjectileHitStatistic(), this);
        manager.registerEvents(new ProjectileLaunchStatistic(), this);
    }

}
