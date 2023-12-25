package simIsland.island;

import lombok.Getter;
import lombok.Setter;
import services.actionServices.Movement;
import services.statisticService.IslandStatistic;
import simIsland.entities.entityActivity.ActionFactory;
import simIsland.entities.entityActivity.Direction;
import simIsland.entities.entityActivity.EntityFactory;
import simIsland.entities.entityListing.Animal;
import simIsland.entities.entityListing.EntityLive;
import simIsland.entities.entityListing.Plant;
import simIsland.immutableParameters.EntityProperties;
import simIsland.immutableParameters.EntityType;
import simIsland.immutableParameters.IslandProperties;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class IslandChart {
    private final int width;
    private final int height;
    private IslandCell[][] cells;
    private final EntityFactory entityFactory;
    private final Movement movement;
    private final IslandStatistic islandStatistic = new IslandStatistic();

    public IslandChart(int width, int height) {
        this.height = height;
        this.width = width;
        this.movement = new Movement();
        this.entityFactory = new EntityFactory();
        this.cells = new IslandCell[width][height];
    }

    public void initialize() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[x][y] = new IslandCell(x, y);
            }
        }
    }

    public void fill() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (EntityType entityType : EntityType.values()) {
                    int entityNumber = EntityProperties.valueOf(entityType.name()).getDensity();
                    while (entityNumber > 0) {
                        EntityLive entity = entityFactory.createEntity(entityType);
                        cells[x][y].addEntity(entity);
                        entityNumber--;
                    }
                }
                shuffleEntities();
            }
        }
    }

    public void shuffleEntities() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                List<EntityLive> list = cells[x][y].getEntityList();
                Collections.shuffle(list);
                cells[x][y].setEntityList(list);
            }
        }
    }

    int getMaxEntities(EntityLive entity) {
        return EntityProperties.valueOf(entity.getName()).getMaxEntitiesInCell() * IslandProperties.ISLAND_HEIGHT * IslandProperties.ISLAND_WIDTH;
    }

    public void printChartStatistic(IslandChart chart) {
        for (Map.Entry<String, Integer> mapEntry : islandStatistic.getChartStatistic(chart).entrySet()) {
            String name = mapEntry.getKey();
            EntityLive entity = entityFactory.createEntity(EntityType.valueOf(name));
            int max = getMaxEntities(entity);
            String symbol = EntityProperties.valueOf(name).getSymbol();
            int iterNumbers = 80 * (mapEntry.getValue()) / max;
            for (int i = 0; i < iterNumbers; i++) {
                System.out.print(symbol);
            }
            System.out.print(" " + mapEntry.getValue() + ":" + name + "s");
            System.out.println();
        }
    }

    public void doMove(int index, IslandCell cell) {
        EntityLive entity = cell.getEntityList().get(index);
        if (Animal.class.isAssignableFrom(entity.getClass())) {
            Animal animal = (Animal) entity;
            int stepCount = animal.getMigration();
            Direction direction;
            int oldX = cell.getCoordinateX();
            int oldY = cell.getCoordinateY();
            IslandCell newCell;
            int newX = 0;
            int newY = 0;
            while (stepCount > 0) {
                direction = Direction.getDirection(ThreadLocalRandom.current().nextInt(4));
                switch (direction) {
                    case UP -> newY = movement.stepUp(cell, this);
                    case DOWN -> newY = movement.stepDown(cell, this);
                    case LEFT -> newX = movement.stepLeft(cell, this);
                    case RIGHT -> newX = movement.stepRight(cell, this);
                }
                stepCount--;
            }
            if (((oldX != newX) || (oldY != newY)) && (this.getCells()[newX][newY].getCellStatistic().get(animal.getName()) < EntityProperties.valueOf(animal.getName()).getMaxEntitiesInCell())) {
                newCell = this.getCells()[newX][newY];
                newCell.addEntity(entity);
                cell.removeEntity(entity, index);
            }
        }
    }

    public void doMoveSingleCell(IslandCell cell) {
        for (int k = 0; k < cell.getEntityList().size(); k++) {
            doMove(k, cell);
        }
    }
}
