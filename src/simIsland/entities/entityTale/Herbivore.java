package simIsland.entities.entityTale;

public abstract class Herbivore extends Animal {
    public Herbivore() {
        super();
    }

    public Herbivore(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(weight, maxEntitiesInCell, migration, maxSaturation);
    }

    @Override
    public void eat(EntityLive food) {

    }
}
