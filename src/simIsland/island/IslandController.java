package simIsland.island;

import lombok.Getter;
import lombok.Setter;
import simIsland.islandSimulation.SimulationSettings;

@Getter
@Setter
public class IslandController {
    private final IslandChart chart;
    private final EatingChart eatingChart;
    private final SimulationSettings settings;

    public IslandController(IslandChart chart, EatingChart eatingChart, SimulationSettings settings) {
        this.chart = chart;
        this.eatingChart = eatingChart;
        this.settings = settings;
    }
}
