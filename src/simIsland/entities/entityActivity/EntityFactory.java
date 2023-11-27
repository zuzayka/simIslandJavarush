package simIsland.entities.entityActivity;

import simIsland.entities.entityTale.*;
import simIsland.entities.utility.EntityType;


public class EntityFactory {
    public EntityLive createEntity(EntityType entityType) {
        return switch (entityType) {
            case BEAR -> new Bear();
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case EAGLE -> new Eagle();
            case GOAT -> new Goat();
            case HORSE -> new Horse();
            case MOUSE -> new Mouse();
            case PYTHON -> new Python();
            case RABBIT -> new Rabbit();
            case SHEEP -> new Sheep();
            case WOLF -> new Wolf();
            case GRASS -> new Grass();
        };
//        return null;
    }
}
