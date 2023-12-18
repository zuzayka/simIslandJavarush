package simIsland.entities.entityListing;

import lombok.Getter;
import lombok.Setter;
import simIsland.immutableParameters.EntityProperties;

@Getter
@Setter
public abstract class Animal extends EntityLive {
    @Getter
    private int migration;
    @Getter
    private double saturation;
    private int lifeTime;

    public Animal() {
        super();
        this.migration = EntityProperties.valueOf(this.getClass().getSimpleName().toUpperCase()).getMigration();
        this.saturation = EntityProperties.valueOf(this.getClass().getSimpleName().toUpperCase()).getMaxSaturation();
        this.lifeTime = EntityProperties.valueOf(this.getClass().getSimpleName().toUpperCase()).getLifeTime();
    }

    public void eat(EntityLive food) {

    }

    public void reproduce() {

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Animal animal = (Animal) o;

        if (migration != animal.migration) return false;
        if (Double.compare(saturation, animal.saturation) != 0) return false;
        return lifeTime == animal.lifeTime;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + migration;
        temp = Double.doubleToLongBits(saturation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + lifeTime;
        return result;
    }

    public static void main(String[] args) {
        Bear b = new Bear();
        System.out.println(b.getSaturation());
    }
}
