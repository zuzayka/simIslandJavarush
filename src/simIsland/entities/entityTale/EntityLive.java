package simIsland.entities.entityTale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simIsland.entities.utility.EntitySymbol;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
@Setter
@AllArgsConstructor
public abstract class EntityLive {
    private double weight;
    private int maxEntitiesInCell;
    private String symbol;
    private int entityDensity;

//    {
//        Properties property = new Properties();
//        FileInputStream fis;
//        FileInputStream fis2;
//        try {
//            fis = new FileInputStream("home/miux/Java/javarush/simIslandJavarush/config/sim.property");
//            property.load(fis);
////            entityDensity = Integer.parseInt(property.getProperty("entity_density"));
////            fis2 =
//        } catch (IOException e) {
//            System.err.println("ОШИБКА: Файл свойств отсуствует!");
//        }
//
//    }

    public EntityLive() {
        Properties property = new Properties();
        FileInputStream fis;
        String entity = this.getClass().getSimpleName().toLowerCase();

        try {
            fis = new FileInputStream("/home/miux/Java/javarush/simIslandJavarush/config/entity.property");
            property.load(fis);
//            System.out.println(calculateEntityDensity());
            this.weight = Double.parseDouble(property.getProperty(entity + ".weight"));
            this.maxEntitiesInCell = Integer.parseInt(property.getProperty(entity + ".maxEntitiesInCell"));
//            String value =
            this.symbol = EntitySymbol.valueOf(property.getProperty(entity + ".symbol")).getEntitySymbol();;
            this.entityDensity = calculateEntityDensity();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует! (EntityLive)");
        }
    }

    public int calculateEntityDensity() {
        Properties property = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("/home/miux/Java/javarush/simIslandJavarush/config/sim.property");
            property.load(fis);
            int density = Integer.parseInt(property.getProperty("density"));
            return density * maxEntitiesInCell / 100;
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует! (calculateEntityDensity)");
            return 0;
        }
    }
}
