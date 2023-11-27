package simIsland.entities.entityTale;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grass extends Plant {
//    private double weight = 1;
//    private int maxEntitiesInCell = 200;


    public Grass() {
        super();
    }

//    public Grass(double weight, int maxEntitiesInCell) {
//        super(1, 200, "");
//    }

    @Override
    public void reproduce() {

    }

    @Override
    public double getWeight(){
        return super.getWeight();
    }

    @Override
    public int getMaxEntitiesInCell() {
        return super.getMaxEntitiesInCell();
    }
}
