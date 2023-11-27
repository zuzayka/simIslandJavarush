package simIsland.island;

import lombok.Getter;
import lombok.Setter;
import simIsland.entities.entityActivity.EntityFactory;
import simIsland.entities.entityTale.EntityLive;
import simIsland.entities.utility.EntityType;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class IslandChart {
    private final int width;
    private final int height;
    private IslandCell[][] cells;
    private final EntityFactory entityFactory;

    public IslandChart(int width, int height) {
        this.height = height;
        this.width = width;
        this.entityFactory = new EntityFactory();
        this.cells = new IslandCell[width][height];
    }

    public void initialize() {
        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[x][y] = new IslandCell(x, y);
                count++;
            }
        }
        System.out.println(count);
    }

    public void fill() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (EntityType entityType : EntityType.values()) {
                    int entityNumber = entityFactory.createEntity(entityType).getEntityDensity();
//                    System.out.println(entityNumber + ":" + entityType.name());
//                    EntityLive entity = entityFactory.createEntity(entityType);
//                    cells[x][y].addEntity(entity);
//                    entityNumber--;
//                    System.out.println(entityNumber + ":" + entityType.name());

                    while (entityNumber > 0) {
                        EntityLive entity = entityFactory.createEntity(entityType);
                        cells[x][y].addEntity(entity);
                        entityNumber--;
                    }
                }
//                System.out.println();
            }
        }
    }

    public void shuffleEntities() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                List<EntityLive> list = cells[x][y].getEntityLst();
                Collections.shuffle(list);
                cells[x][y].setEntityLst(list);
            }
        }
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

//    public static void main(String[] args)
//    {
//        List<String> list = Arrays.asList("1", "2,", "3", "4", "5", "6", "7", "8", "9", "10");
//        Collections.shuffle(list);
//        List<String> list2 = list;
//        System.out.println(list2);
//    }

//    public static void main(String[] args) {
//        EntityLive bear = new Bear();
//        System.out.println(bear.getEntityDensity());
//    }

    public static void main(String[] args) {
        IslandChart chart = new IslandChart(100, 20);
        chart.initialize();
        chart.fill();
        System.out.println();
    }
}
