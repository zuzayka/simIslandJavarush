package simIsland.islandSimulation;

import simIsland.island.IslandChart;
import simIsland.island.IslandController;

public class SimulationStarter {
    private final IslandChart islandChart;
    private final SimulationSettings settings;
    private final IslandController islandController;

    public SimulationStarter() {
        this.settings = new SimulationSettings();
        this.islandChart = new IslandChart(settings.getWidthChart(), settings.getHeightChart());
        this.islandController = new IslandController(islandChart, null, settings);
    }

    public void start() {
        islandController.getChart().initialize();
        islandController.getChart().fill();
    }

    public static void main(String[] args) {
        SimulationStarter starter = new SimulationStarter();
        starter.start();
        System.out.println("finish");
    }
}
