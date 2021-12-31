import java.util.HashMap;

public class SnakeLadderPositions {
    private final HashMap<Integer, Integer> SnakePosition = new HashMap<>();
    private final HashMap<Integer, Integer> LadderPosition = new HashMap<>();

    void setSnakePosition(int Head, int Tail) {
        SnakePosition.put(Head, Tail);
    }

    void setLadderPosition(int Tail, int Head) {
        LadderPosition.put(Tail, Head);
    }

    int isItSnake(int Position) {
        if (SnakePosition.get(Position) == null) return -1;
        return SnakePosition.get(Position);
    }

    int isItLadder(int Position) {
        if (LadderPosition.get(Position) == null) return -1;
        return LadderPosition.get(Position);
    }
}
