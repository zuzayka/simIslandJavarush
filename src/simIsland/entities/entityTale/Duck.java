package simIsland.entities.entityTale;

public class Duck extends Omnivore {
    public Duck() {
        super();
    }

    public Duck(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(1, 200, 4, 0.15);
    }
}
