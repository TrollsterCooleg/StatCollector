package me.cooleg.statcollector.statisticsmanagement;

import org.bukkit.event.Listener;

import java.util.UUID;

public interface Statistic extends Listener {

    String getName();

    default void setStatistic(UUID id, double num) {
        PlayerStatistics player = PlayerStatistics.getPlayer(id);
        player.setStatistic(this, num);
    }

    default double getStatistic(UUID id) {
        PlayerStatistics player = PlayerStatistics.getPlayer(id);
        return player.getStatistic(this);
    }

    default void addStatistic(UUID id, double num) {
        PlayerStatistics player = PlayerStatistics.getPlayer(id);
        player.addStatistic(this, num);
    }

    default void incrementStatistic(UUID id) {
        addStatistic(id, 1);
    }

}
