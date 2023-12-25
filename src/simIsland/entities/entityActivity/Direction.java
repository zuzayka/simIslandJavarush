package simIsland.entities.entityActivity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;


    public static Direction getDirection(int index) {
        return switch (index) {
            case 0 -> UP;
            case 1 -> DOWN;
            case 2 -> LEFT;
            case 3 -> RIGHT;
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    public static void main(String[] args) {
        Direction d = Direction.valueOf("UP");
        System.out.println(d);
    }
}
