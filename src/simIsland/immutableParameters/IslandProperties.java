package simIsland.immutableParameters;

import lombok.Getter;

@Getter
public class IslandProperties {
    public static final int DENSITY_CONST = 20;
    public static final int ISLAND_WIDTH_CONST = 10;
    public static final int ISLAND_HEIGHT_CONST = 10;
    public static final int ISLAND_CYCLES_CONST  = 50;
    public static final double SATURATION_REDUCE  = 0.4;
    public static final double ENOUGH_SATURATION  = 0.5;


    public static int DENSITY;
    public static int ISLAND_WIDTH;
    public static int ISLAND_HEIGHT;
    public static int ISLAND_CYCLES;

}
