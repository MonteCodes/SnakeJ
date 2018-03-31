package monte.snake.model;

import java.util.LinkedList;

public class Snake {

    private LinkedList<Tile> snake;
    private Direction direction;

    public Snake(int x, int y) {
        this.snake = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            this.snake.add(new Tile(x - i, y));
        }
        this.direction = Direction.RIGHT;
    }

    public void changeDirection(Direction d) {
        if (!direction.isOpposite(d)) {
            direction = d;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void move() {
        Tile newHead = new Tile(getHead().x + direction.x, getHead().y + direction.y);
        snake.addFirst(newHead);
    }

    public void removeTail() {
        snake.removeLast();
    }

    public void addNewHead(Tile c) {
        snake.addFirst(c);
    }

    public Tile getHead() {
        return snake.getFirst();
    }

    public Tile getTail() {
        return snake.getLast();
    }

    public LinkedList<Tile> getSegments() {
        return snake;
    }

    public boolean contains(Tile t) {
        return snake.contains(t);
    }
}
