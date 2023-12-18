package services.statisticService;

import simIsland.entities.entityListing.EntityLive;
import simIsland.island.IslandCell;
import simIsland.island.IslandChart;
import java.util.HashMap;
import java.util.Map;

public class IslandStatistic {
    public void addToCellStatistic(EntityLive entity, Map<String, Integer> cellStatistic) {
        for (Map.Entry<String, Integer> entry : cellStatistic.entrySet()) {
            if (entry.getKey().equals(entity.getName())) {
                entry.setValue(entry.getValue() + 1);
                break;
            }
        }
    }

    public void removeFromCellStatistic(EntityLive entity, Map<String, Integer> cellStatistic) {
        for (Map.Entry<String, Integer> entry : cellStatistic.entrySet()) {
            if (entry.getKey().equals(entity.getName())) {
                entry.setValue(entry.getValue() - 1);
                break;
            }
        }
    }

    public Map<String, Integer> getChartStatistic(IslandChart chart) {
        Map<String, Integer> statistic = getNewStatisticMap();
        for (int y = 0; y < chart.getHeight(); y++) {
            for (int x = 0; x < chart.getWidth(); x++) {
                IslandCell cell = chart.getCells()[x][y];
                Map<String, Integer> cellStatistic = cell.getCellStatistic();
                addMap(statistic, cellStatistic);
            }
        }
        return statistic;
    }

    public Map<String, Integer> getNewStatisticMap() {
        Map<String, Integer> statistic = new HashMap<>();
        statistic.put("BEAR", 0);
        statistic.put("BOAR", 0);
        statistic.put("BUFFALO", 0);
        statistic.put("CATERPILLAR", 0);
        statistic.put("DEER", 0);
        statistic.put("DUCK", 0);
        statistic.put("EAGLE", 0);
        statistic.put("FOX", 0);
        statistic.put("GOAT", 0);
        statistic.put("GRASS", 0);
        statistic.put("HORSE", 0);
        statistic.put("MOUSE", 0);
        statistic.put("PYTHON", 0);
        statistic.put("RABBIT", 0);
        statistic.put("SHEEP", 0);
        statistic.put("WOLF", 0);
        return statistic;
    }

    public void addMap(Map<String, Integer> map1, Map<String, Integer> map2) {
        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                    entry1.setValue(entry1.getValue() + entry2.getValue());
                }
            }
        }
    }
}
