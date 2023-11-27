package simIsland.islandSimulation;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
@Setter
public class SimulationSettings {
    private int widthChart;
    private int heightChart;
    private int simulationCycles;


    {
        Properties property = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("/home/miux/Java/javarush/simIslandJavarush/config/sim.property");
            property.load(fis);
            widthChart = Integer.parseInt(property.getProperty("island_width"));
            heightChart = Integer.parseInt(property.getProperty("island_height"));
            simulationCycles = Integer.parseInt(property.getProperty("island_cycles"));
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public static void main(String[] args) {
        SimulationSettings settings = new SimulationSettings();
        System.out.println(settings.widthChart + ":" + settings.heightChart);
    }
}
