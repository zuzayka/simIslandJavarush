package simIsland.island;

import lombok.Getter;
import lombok.Setter;
import services.statisticService.IslandStatistic;
import simIsland.entities.entityActivity.EntityFactory;
import simIsland.entities.entityListing.Animal;
import simIsland.entities.entityListing.EntityLive;
import simIsland.immutableParameters.EntityProperties;
import simIsland.immutableParameters.EntityType;
import simIsland.immutableParameters.FoodSuitability;
import simIsland.immutableParameters.IslandProperties;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public class IslandCell {
    private int coordinateX;
    private int coordinateY;
    private List<EntityLive> entityList;
    private final IslandStatistic islandStatistic = new IslandStatistic();
    private Map<String, Integer> cellStatistic = islandStatistic.getNewStatisticMap();
    private final EntityFactory factory = new EntityFactory();


    public IslandCell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.entityList = new ArrayList<>();
    }

    public void addEntity(EntityLive entity) {
        islandStatistic.addToCellStatistic(entity, cellStatistic);
        entityList.add(entity);
    }

    public void removeEntity(EntityLive entity, int index) {
        islandStatistic.removeFromCellStatistic(entity, cellStatistic);
        entityList.remove(index);
    }

    public void procreate(int j) {
        EntityLive entity = entityList.get(j);
        int interval = entity.getIntervalProcreation();
        interval--;
        entity.setIntervalProcreation(interval);
        if (interval == 0) {
            EntityLive entityNew = factory.createEntity(EntityType.valueOf(entity.getName()));
            entity.setIntervalProcreation(EntityProperties.valueOf(entity.getName()).getIntervalProcreation());
            if (cellStatistic.get(entity.getName()) < EntityProperties.valueOf(entity.getName()).getMaxEntitiesInCell()) {
                addEntity(entityNew);
            }
        }
    }

    public void procreateInCell() {
        for (int k = 0; k < entityList.size(); k++) {
            procreate(k);
        }
    }

    public void increaseSaturation(int i) {
        EntityLive entity = entityList.get(i);
        if (Animal.class.isAssignableFrom(entity.getClass())) {
            Animal animal = (Animal) entity;
            String name = animal.getName();
            double maxSaturation = EntityProperties.valueOf(name).getMaxSaturation();
            double enoughSaturation = maxSaturation * IslandProperties.ENOUGH_SATURATION;
            double saturation = animal.getSaturation();
            if (Double.compare(saturation, enoughSaturation) > 0) {
                return;
            }
            int count = 1;
            while (entityList.size() - count > 0) {
                EntityLive food = entityList.get(entityList.size() - count);
                String foodName = food.getName();
                Map<String, Integer> map = FoodSuitability.getMap(name);
                int suitability = (int) (new Random().nextDouble() * 100);
                if (map.get(foodName) > suitability) {
                    saturation += EntityProperties.valueOf(foodName).getWeight();
                    if (Double.compare(saturation, maxSaturation) > 0) {
                        removeEntity(food, entityList.size() - count);
                        saturation = maxSaturation;
                        break;
                    }
                    if (Double.compare(saturation, enoughSaturation) > 0) {
                        break;
                    }
                    if (entityList.size() - count > 0) {
                        count++;
                    } else {
                        break;
                    }
                } else {
                    count++;
                }
            }
            animal.setSaturation(saturation);
        }
    }

    public void increaseSaturationInCell() {
        for (int k = 0; k < entityList.size(); k++) {
            increaseSaturation(k);
        }
    }

    public boolean reduceSaturation(int index) {
        EntityLive entity = entityList.get(index);
        if (Animal.class.isAssignableFrom(entity.getClass())) {
            Animal animal = (Animal) entity;
            double saturation = animal.getSaturation() - EntityProperties.valueOf(animal.getName()).getSaturationDif();
            if (Double.compare(saturation, 0.01) < 0) {
                return false;
            } else {
                animal.setSaturation(saturation);
                return true;
            }
        }
        return true;
    }

    public void reduceSaturationInCell() {
        int j = 0;
        while (j != entityList.size()) {
            boolean satCondition = reduceSaturation(j);
            if (satCondition) {
                j++;
            } else {
                removeEntity(entityList.get(j), j);
            }
        }
    }
}
