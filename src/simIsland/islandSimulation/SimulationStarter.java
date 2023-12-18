package simIsland.islandSimulation;

import simIsland.entities.entityListing.EntityLive;
import simIsland.immutableParameters.IslandProperties;
import simIsland.island.IslandCell;
import simIsland.island.IslandChart;

import java.util.List;

public class SimulationStarter {
    private final IslandChart islandChart;
    private final SimulationSettings settings;
    private int tactCount = 1;

    public SimulationStarter() {
        this.settings = new SimulationSettings();
        this.islandChart = new IslandChart(settings.getWidthChart(), settings.getHeightChart());

    }

    public void start() {
        islandChart.initialize();
        islandChart.fill();
    }

    public void proceed() {
        for (int i = 0; i < IslandProperties.ISLAND_CYCLES; i++) {
            executeTact();
        }
    }

    private void executeTact() {
        System.out.println("\n      Tact number: " + tactCount);
        tactCount++;
        for (int y = 0; y < islandChart.getHeight(); y++) {
            for (int x = 0; x < islandChart.getWidth(); x++) {
                IslandCell cell = islandChart.getCells()[x][y];
                islandChart.doMoveSingleCell(cell);
                cell.increaseSaturationInCell();
                cell.procreateInCell();
                cell.reduceSaturationInCell();
            }
        }
        islandChart.printChartStatistic(islandChart);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
