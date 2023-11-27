package simIsland.entities.entityTale;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        super();
    }

    public Caterpillar(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(0.01, 1000, 0, 0.03);
    }
}
