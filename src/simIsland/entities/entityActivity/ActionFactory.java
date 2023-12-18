package simIsland.entities.entityActivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import simIsland.entities.entityListing.*;
import simIsland.island.IslandCell;
import simIsland.island.IslandChart;

@Getter
@Setter
@AllArgsConstructor
public class ActionFactory {
    private IslandCell cell;
    private EntityLive entity;
    private IslandChart chart;

    public void execute(EntityLive entity) {
        switch (entity.getName()) {
            case "BEAR", "BOAR", "BUFFALO", "CATERPILLAR", "DEER", "DUCK", "EAGLE", "FOX", "GOAT", "HORSE", "MOUSE", "PYTHON", "RABBIT", "SHEEP", "WOLF" ->
                    executeTactAnimal(0);
            case "GRASS" -> executeTactPlant();
        }
    }

    public void executeTactAnimal(int index) {
        cell.removeEntity(cell.getEntityList().get(index), index);
    }

    public void executeTactPlant() {
    }
}
