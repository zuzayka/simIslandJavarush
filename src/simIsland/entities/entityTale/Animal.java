package simIsland.entities.entityTale;

import lombok.Getter;
import lombok.Setter;
import simIsland.entities.entityActivity.Direction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@Getter
@Setter
public abstract class Animal extends EntityLive {
    private int migration;
    private double maxSaturation;
    private int lifeTime;
    private int intervalProcreation;
    private int minLitter;
    private int maxLitter;

    public Animal() {
        super();

        Properties property = new Properties();
        FileInputStream fis;
        String animal = this.getClass().getSimpleName().toLowerCase();

        try {
            fis = new FileInputStream("/home/miux/Java/javarush/simIslandJavarush/config/entity.property");
            property.load(fis);
//            System.out.println(calculateEntityDensity());
            this.migration = Integer.parseInt(property.getProperty(animal + ".migration"));
            this.maxSaturation = Double.parseDouble(property.getProperty(animal + ".maxSaturation"));
            this.lifeTime = Integer.parseInt(property.getProperty(animal + ".lifeTime"));;
            this.intervalProcreation = Integer.parseInt(property.getProperty(animal + ".intervalProcreation"));;
            this.minLitter = Integer.parseInt(property.getProperty(animal + ".minLitter"));;
            this.maxLitter = Integer.parseInt(property.getProperty(animal + ".maxLitter"));;
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!(Animal)");
        }
    }

    public Animal(double weight, int maxEntitiesInCell, int migration, double maxSaturation) {
    }

//    public Animal(double weight, int maxEntitiesInCell, int migration, double maxSaturation,
//                  int lifeTime, int intervalProcreation, int minLitter, int maxLitter) {
//        super(weight, maxEntitiesInCell);
//        this.migration = migration;
//        this.maxSaturation = maxSaturation;
//        this.lifeTime = lifeTime;
//        this.intervalProcreation = intervalProcreation;
//        this.minLitter = minLitter;
//        this.maxLitter = maxLitter;
//    }

//    public Animal(double weight, int maxEntitiesInCell, int migration, double maxSaturation,
//                  int lifeTime, int minLitter, int maxLitter) {
//        super(weight, maxEntitiesInCell);
//        this.migration = migration;
//        this.maxSaturation = maxSaturation;
//
//    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public int getMaxEntitiesInCell() {
        return super.getMaxEntitiesInCell();
    }

    public int getMigration() {
        return migration;
    }

    public double getMaxSaturation() {
        return maxSaturation;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public int getIntervalProcreation() {
        return intervalProcreation;
    }

    public int getMinLitter() {
        return minLitter;
    }

    public int getMaxLitter() {
        return maxLitter;
    }

    public void move() {

    }

    public void eat(EntityLive food) {

    }

    public void reproduce() {

    }

    public void terminate() {

    }

//    public Direction chooseDirection() {
//        return Direction.values()[new Random().nextInt(4)];
//    }

    public static void main(String[] args) {
        Bear b = new Bear();
        System.out.println(b.getMaxSaturation() + " " + b.getEntityDensity());
    }
}
