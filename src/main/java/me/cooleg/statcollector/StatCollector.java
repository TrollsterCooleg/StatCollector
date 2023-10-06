package me.cooleg.statcollector;

import club.minnced.discord.webhook.WebhookClient;
import me.cooleg.statcollector.commands.SaveToFile;
import me.cooleg.statcollector.commands.ToggleCollecting;
import me.cooleg.statcollector.commands.WipeStats;
import me.cooleg.statcollector.defaultstatistics.*;
import me.cooleg.statcollector.hooks.CommandAPIHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class StatCollector extends JavaPlugin {

    private static WebhookClient client;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("savestats").setExecutor(new SaveToFile(this));
        getCommand("togglecollecting").setExecutor(new ToggleCollecting());
        getCommand("wipestats").setExecutor(new WipeStats());
        registerEvents();

        if (Bukkit.getPluginManager().isPluginEnabled("CommandAPI")) {new CommandAPIHook().registerCommands();}
        try {
            client = WebhookClient.withUrl(getConfig().getString("webhook"));
        } catch (IllegalArgumentException ex) {
            Bukkit.getLogger().severe("No webhook has been specified for StatCollector! A webhook is highly recommended.");
            client = null;
        }

    }

    public static void sendFileToWebhook(File file) {
        if (client == null) {return;}
        client.send(file);
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
