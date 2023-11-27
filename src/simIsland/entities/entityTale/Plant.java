package simIsland.entities.entityTale;

public abstract class Plant extends EntityLive {
    public Plant() {
        }

//    public Plant(double weight, int maxEntitiesInCell, String symbol) {
//        super(weight, maxEntitiesInCell, symbol);
//    }

    public abstract void reproduce();
}
