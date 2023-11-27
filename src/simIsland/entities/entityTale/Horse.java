package simIsland.entities.entityTale;

public class Horse extends Herbivore {
    public Horse() {
        super();
    }

    public Horse(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
        super(400, 20, 4, 60);
    }

//    @Override
//    public String toString() {
//        return "Horse{" + getWeight() + ":" + getMaxEntitiesInCell() + ":" + getMaxSaturation() + ":" + getMigration() + "}";
//    }
//
//    public static void main(String[] args) {
//        Horse h;
//        h = new Horse(1, 5, 9, 11);
//        System.out.println(h);
//    }
}
