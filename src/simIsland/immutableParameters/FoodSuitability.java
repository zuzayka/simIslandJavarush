package simIsland.immutableParameters;

import java.util.*;

public class FoodSuitability {
    /*
        массивы пригодности для пищи
        расположение в массиве типов организмов: BEAR, BOAR, BUFFALO, CATERPILLAR, DEER, DUCK,
        EAGLE, GOAT, HORSE, MOUSE, PYTHON, RABBIT, SHEEP, WOLF, GRASS
    */

    public static final int[] BEAR_FOOD = new int[]{0, 50, 20, 0, 80, 10, 0, 0, 70, 40, 90, 80, 80, 70, 0, 0};
    public static final int[] BOAR_FOOD = new int[]{0, 0, 0, 90, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 100};
    public static final int[] BUFFALO_FOOD = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    public static final int[] CATERPILLAR_FOOD = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    public static final int[] DEER_FOOD = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    public static final int[] DUCK_FOOD = new int[]{0, 0, 0, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    public static final int[] EAGLE_FOOD = new int[]{0, 0, 0, 0, 0, 80, 0, 10, 0, 0, 90, 0, 90, 0, 0, 0};
    public static final int[] FOX_FOOD = new int[]{0, 0, 0, 40, 0, 60, 0, 0, 0, 0, 90, 0, 70, 0, 0, 0};
    public static final int[] GOAT_FOOD = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
    public static final int[] HORSE_FOOD = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10};
    public static final int[] MOUSE_FOOD = new int[]{0, 0, 0, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    public static final int[] PYTHON_FOOD = new int[]{0, 0, 0, 0, 0, 10, 0, 15, 0, 0, 40, 0, 20, 0, 0, 0};
    public static final int[] RABBIT_FOOD = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    public static final int[] SHEEP_FOOD = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
    public static final int[] WOLF_FOOD = new int[]{0, 0, 10, 0, 15, 40, 0, 0, 60, 10, 80, 0, 60, 70, 0, 0};
    public static final String[] NAMES = new String[]{"BEAR", "BOAR", "BUFFALO", "CATERPILLAR", "DEER", "DUCK",
            "EAGLE", "FOX", "GOAT", "HORSE", "MOUSE", "PYTHON", "RABBIT", "SHEEP", "WOLF", "GRASS"};


    public static final Map<String, Integer> BEAR = makeMap(BEAR_FOOD);
    public static final Map<String, Integer> BOAR = makeMap(BOAR_FOOD);
    public static final Map<String, Integer> BUFFALO = makeMap(BUFFALO_FOOD);
    public static final Map<String, Integer> CATERPILLAR = makeMap(CATERPILLAR_FOOD);
    public static final Map<String, Integer> DEER = makeMap(DEER_FOOD);
    public static final Map<String, Integer> DUCK = makeMap(DUCK_FOOD);
    public static final Map<String, Integer> EAGLE = makeMap(EAGLE_FOOD);
    public static final Map<String, Integer> FOX = makeMap(FOX_FOOD);
    public static final Map<String, Integer> GOAT = makeMap(GOAT_FOOD);
    public static final Map<String, Integer> HORSE = makeMap(HORSE_FOOD);
    public static final Map<String, Integer> MOUSE = makeMap(MOUSE_FOOD);
    public static final Map<String, Integer> PYTHON = makeMap(PYTHON_FOOD);
    public static final Map<String, Integer> RABBIT = makeMap(RABBIT_FOOD);
    public static final Map<String, Integer> SHEEP = makeMap(SHEEP_FOOD);
    public static Map<String, Integer> WOLF = makeMap(WOLF_FOOD);

    private static Map<String, Integer> makeMap(int[] values) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < FoodSuitability.NAMES.length; i++) {
            map.put(FoodSuitability.NAMES[i], values[i]);
        }
        return map;
    }

    public static Map<String, Integer> getMap(String s) {
        return switch (s) {
            case "BEAR" -> BEAR;
            case "BOAR" -> BOAR;
            case "BUFFALO" -> BUFFALO;
            case "CATERPILLAR" -> CATERPILLAR;
            case "DEER" -> DEER;
            case "DUCK" -> DUCK;
            case "EAGLE" -> EAGLE;
            case "FOX" -> FOX;
            case "GOAT" -> GOAT;
            case "HORSE" -> HORSE;
            case "MOUSE" -> MOUSE;
            case "PYTHON" -> PYTHON;
            case "RABBIT" -> RABBIT;
            case "SHEEP" -> SHEEP;
            case "WOLF" -> WOLF;
            default -> null;
        };
    }
}
