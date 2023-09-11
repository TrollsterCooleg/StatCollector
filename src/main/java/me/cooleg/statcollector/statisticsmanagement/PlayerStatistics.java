package me.cooleg.statcollector.statisticsmanagement;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class PlayerStatistics {

    private static final HashMap<UUID, PlayerStatistics> players = new HashMap<>();
    private static final HashSet<String> allStatistics = new HashSet<>();
    private static final HashSet<String> allProperties = new HashSet<>();
    private static boolean collect = false;

    private final HashMap<String, Double> statisticsStorage = new HashMap<>();
    private final HashMap<String, String> propertyStorage = new HashMap<>();
    private final UUID id;

    private PlayerStatistics(UUID id) {
        this.id = id;
        setProperty("Username", Bukkit.getOfflinePlayer(id).getName());
        players.put(id, this);
    }

    public static PlayerStatistics getPlayer(UUID id) {
        PlayerStatistics statistics = players.get(id);
        if (statistics != null) {return statistics;}
        return new PlayerStatistics(id);
    }

    public void setStatistic(String stat, double num) {
        if (!collect) {return;}
        allStatistics.add(stat);
        statisticsStorage.put(stat, num);
    }

    public double getStatistic(String stat) {
        allStatistics.add(stat);
        Double num = statisticsStorage.get(stat);
        if (num == null) {return 0.0;}
        return num;
    }

    public void addStatistic(String stat, double num) {
        if (!collect) {return;}
        double newStat = getStatistic(stat) + num;
        setStatistic(stat, newStat);
    }

    public void setStatistic(Statistic stat, double num) {
        setStatistic(stat.getName(), num);
    }

    public double getStatistic(Statistic stat) {
        return getStatistic(stat.getName());
    }

    public void addStatistic(Statistic stat, double num) {
        addStatistic(stat.getName(), num);
    }

    public void setProperty(String property, String value) {
        allProperties.add(property);
        propertyStorage.put(property, value);
    }

    public String getProperty(String property) {
        String value = propertyStorage.get(property);
        return value != null ? value : "NONE";
    }

    public HashMap<String, String> getPropertyValues() {return propertyStorage;}
    public UUID getId() {return id;}

    public static HashMap<UUID, PlayerStatistics> getPlayers() {
        return players;
    }
    public static HashSet<String> getStatistics() {
        return allStatistics;
    }

    public static HashSet<String> getProperties() {
        return allProperties;
    }

    public static boolean getCollecting() {return collect;}
    public static void setCollecting(boolean collecting) {collect = collecting;}
    public static void clearStatistics() {players.clear(); allStatistics.clear(); allProperties.clear();}

}
