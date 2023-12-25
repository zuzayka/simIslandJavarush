package simIsland.immutableParameters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EntityProperties {
    BEAR("\uD83D\uDC3B", 500, 5, 2, 80, 50, 5, 1),
    BOAR("\uD83D\uDC17", 400, 50, 2, 50, 50, 4, 2),
    BUFFALO("\uD83D\uDC02", 700, 10, 3, 100, 40, 4, 2),
    CATERPILLAR("\uD83D\uDC1B", 0.2, 500, 1, 1, 3, 2, 15),
    DEER("\uD83E\uDD8C", 300, 20, 4, 50, 40, 3, 1),
    DUCK("\uD83E\uDD86", 2, 150, 5, 1, 20, 3, 3),
    EAGLE("\uD83E\uDD85", 6, 20, 4, 2, 40, 4, 1),
    FOX("🦊", 8, 30, 2, 2, 35, 4, 3),
    GOAT("\uD83D\uDC10", 8, 30, 2, 2, 35, 4, 1),
    GRASS("🌱", 1, 300, 0, 0, 0, 1, 0),
    HORSE("\uD83D\uDC0E", 400, 20, 4, 60, 40, 4, 1),
    MOUSE("\uD83D\uDC01", 0.5, 400, 1, 1, 10, 3, 3),
    PYTHON("\uD83D\uDC0D", 15, 30, 1, 3, 30, 3, 2),
    RABBIT("\uD83D\uDC07", 3, 120, 2, 2, 25, 2, 4),
    SHEEP("\uD83D\uDC11", 70, 140, 3, 12, 35, 4, 1),
    WOLF("\uD83D\uDC3A", 50, 30, 3, 8, 40, 4, 1);
    private final String symbol;
    private final double weight;
    private final int maxEntitiesInCell;
    private final int migration;
    private final double maxSaturation;
    private final int lifeTime;
    private final int intervalProcreation;
    private final int litter;

    public int getDensity() {
        int density = maxEntitiesInCell * IslandProperties.DENSITY / 100;
        if (density != 0) {
            return maxEntitiesInCell * IslandProperties.DENSITY / 100;
        }
        return 1;
    }

    public double getSaturationDif() {
        return maxSaturation * IslandProperties.SATURATION_REDUCE;
    }
}
