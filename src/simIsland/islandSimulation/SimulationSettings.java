package simIsland.islandSimulation;

import dialogs.SimulationDialog;
import lombok.Getter;
import lombok.Setter;
import simIsland.immutableParameters.IslandProperties;

@Getter
@Setter
public class SimulationSettings {
    private int widthChart;
    private int heightChart;
    private int simulationCycles;
    private int entityDensity;
    private double saturationReduce;
    private SimulationDialog dialog;

    public SimulationSettings() {
        this.dialog = new SimulationDialog();
        this.widthChart = dialog.getScannerWidth();
        this.heightChart = dialog.getScannerHeight();
        this.simulationCycles = dialog.getScannerCycles();
        this.entityDensity = dialog.getScannerDensity();
        this.saturationReduce = IslandProperties.SATURATION_REDUCE;
    }
}
