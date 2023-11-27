package simIsland.island;

import lombok.Getter;
import lombok.Setter;
import simIsland.entities.entityTale.Bear;
import simIsland.entities.entityTale.EntityLive;

import java.util.*;

@Getter
@Setter
public class IslandCell {
    private int coordinateX;
    private int coordinateY;
    private List<EntityLive> entityLst = new ArrayList<>();
    public Map<String, Integer> cellStatistic = new HashMap<>();

    public IslandCell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

//    public void fillCelStatistic(Map<EntityLive, Integer> celStatistic) {
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//        celStatistic.put(new Bear(), 0);
//
//
//    }

    public void addEntity(EntityLive entity) {
        entityLst.add(entity);
        String entityName = entity.getClass().getSimpleName();
        cellStatistic.merge(entityName, 1, (oldV, newV) -> oldV + 1);
    }

    public void removeEntity(EntityLive entity) {
        String entityString = getEntityName(entity);
        cellStatistic.merge(entityString, 1, (oldV, newV) -> {
            int newCount = oldV - 1;
            if (newCount <= 0) {
                return null;
            }
            return newCount;
        });
        entityLst.remove(entity);
    }

    private String getEntityName(EntityLive entity) {
        return entity.getClass().getSimpleName();
    }
}
