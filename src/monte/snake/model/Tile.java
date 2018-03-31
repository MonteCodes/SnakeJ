package monte.snake.model;

public class Tile {
    public final int x;
    public final int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tile)) {
            return false;
        }

        return (this.x == ((Tile) obj).x) && (this.y == ((Tile) obj).y);
    }
}
