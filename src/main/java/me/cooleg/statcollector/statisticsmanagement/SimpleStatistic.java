package me.cooleg.statcollector.statisticsmanagement;

public class SimpleStatistic implements Statistic {

    private final String name;

    public SimpleStatistic(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
