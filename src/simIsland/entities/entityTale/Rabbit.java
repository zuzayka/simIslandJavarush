package simIsland.entities.entityTale;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super();
    }

    public Rabbit(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(2, 150, 2, 0.45);
    }

    @Override
    public void eat(EntityLive food) {

    }

    @Override
    public void reproduce() {

    }
}
