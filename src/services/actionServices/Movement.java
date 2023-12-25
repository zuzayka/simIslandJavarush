package services.actionServices;

import simIsland.immutableParameters.IslandProperties;
import simIsland.island.IslandCell;
import simIsland.island.IslandChart;

public class Movement {


    public Movement() {
    }

    public int stepUp(IslandCell cell, IslandChart chart) {
        int x = cell.getCoordinateX();
        int y = cell.getCoordinateY();
        if (y == IslandProperties.ISLAND_HEIGHT - 1) {
            return y--;
        } else {
            return y++;
        }
    }

    public int stepDown(IslandCell cell, IslandChart chart) {
        int x = cell.getCoordinateX();
        int y = cell.getCoordinateY();
        if (y == 0) {
            return y++;
        } else {
            return y--;
        }
    }

    public int stepLeft(IslandCell cell, IslandChart chart) {
        int x = cell.getCoordinateX();
        int y = cell.getCoordinateY();
        if (x == 0) {
            return x++;
        } else {
            return x--;
        }
    }

    public int stepRight(IslandCell cell, IslandChart chart) {
        int x = cell.getCoordinateX();
        int y = cell.getCoordinateY();
        if (x == IslandProperties.ISLAND_WIDTH - 1) {
            return x--;
        } else {
            return x++;
        }
    }
}
