package simIsland.entities.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EntitySymbol {
//    BEAR("bear", Bear.class),
//    BOAR("boar", Boar.class),
//    BUFFALO("buffalo", Builder.class),
//    CATERPILLAR("caterpillar", Caterpillar.class),
//    DEER("deer", Deer.class),
//    DUCK("duck", Duck.class),
//    EAGLE("eagle", Eagle.class),
//    GOAT("goat", Goat.class),
//    HORSE("horse", Horse.class),
//    MOUSE("mouse", Mouse.class),
//    PYTHON("python", Python.class),
//    RABBIT("rabbit", Rabbit.class),
//    SHEEP("sheep", Sheep.class),
//    WOLF("wolf", Wolf.class),
//    GRASS("grass", Grass.class);
//
//    private final String entityName;
//    private final Class entityClass;
//
//    public String getName() {
//        return entityName;
//    }
    BEAR("\uD83D\uDC3B"),
    BOAR("\uD83D\uDC17"),
    BUFFALO("\uD83D\uDC02"),
    CATERPILLAR("\uD83D\uDC1B"),
    DEER("\uD83E\uDD8C"),
    DUCK("\uD83E\uDD86"),
    EAGLE("\uD83E\uDD85"),
    GOAT("\uD83D\uDC10"),
    GRASS("🌱"),
    HORSE("\uD83D\uDC0E"),
    MOUSE("\uD83D\uDC01"),
    PYTHON("\uD83D\uDC0D"),
    RABBIT("\uD83D\uDC07"),
    SHEEP(""),
    WOLF("\uD83D\uDC3A");
    private String entitySymbol;


    public static void main(String[] args) {

        System.out.println(BEAR.getEntitySymbol());
    }
}
