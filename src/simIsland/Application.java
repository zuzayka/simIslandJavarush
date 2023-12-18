package simIsland;

import simIsland.islandSimulation.SimulationStarter;

public class Application {
    public static void main(String[] args) {
        SimulationStarter starter = new SimulationStarter();
        starter.start();
        starter.proceed();
    }
}
