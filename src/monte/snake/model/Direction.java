package monte.snake.model;

public enum  Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    public int x;
    public int y;

    public boolean isOpposite(Direction direction) {
        return this.x + direction.x == 0 && this.y + direction.y == 0;
    }

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
