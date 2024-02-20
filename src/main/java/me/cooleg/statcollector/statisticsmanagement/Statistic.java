package me.cooleg.statcollector.statisticsmanagement;

import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.Map;
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

    default Map<UUID, Double> getAllScores() {
        HashMap<UUID, Double> scores = new HashMap<>();

        for (Map.Entry<UUID, PlayerStatistics> entries : PlayerStatistics.getPlayers().entrySet()) {
            scores.put(entries.getKey(), entries.getValue().getStatistic(this));
        }

        return scores;
    }

}
