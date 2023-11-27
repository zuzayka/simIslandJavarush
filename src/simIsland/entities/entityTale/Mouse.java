package simIsland.entities.entityTale;

public class Mouse extends Omnivore {
    public Mouse() {
        super();
    }

    public Mouse(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(0.05, 500, 1, 0.01);
    }
}
