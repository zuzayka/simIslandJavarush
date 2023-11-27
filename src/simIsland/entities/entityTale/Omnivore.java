package simIsland.entities.entityTale;

public abstract class Omnivore extends Animal {

    public Omnivore() {
        super();
    }

    public Omnivore(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(weight, maxEntitiesInCell, migration, maxSaturation);
    }
}
