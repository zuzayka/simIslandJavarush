package simIsland.entities.entityTale;

public abstract class Carnivore extends Animal {
    public Carnivore() {
    }

    public Carnivore(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(weight, maxEntitiesInCell, migration, maxSaturation);
    }
}
