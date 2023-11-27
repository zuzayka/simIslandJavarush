package dialogs;

import simIsland.islandSimulation.SimulationSettings;
import simIsland.islandSimulation.SimulationStarter;

import java.util.Scanner;

public class SimulationDialog {
    private final SimulationSettings settings;

    public SimulationDialog(SimulationSettings settings) {
        this.settings = settings;

        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter island width");
            settings.setWidthChart(scanner.nextInt());
            System.out.println("Enter island height");
            settings.setHeightChart(scanner.nextInt());
            System.out.println("Island width: " + settings.getWidthChart() + ", island height: " + settings.getHeightChart());
        }
    }

//    public static void main(String[] args) {
//        SimulationDialog sd = new SimulationDialog(new SimulationSettings());
//    }
}
