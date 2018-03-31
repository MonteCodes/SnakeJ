package monte.snake.model;

import monte.snake.util.Settings;

import java.util.Random;

public class Garden {
    private final static Random random = new Random();

    private Snake snake;
    private Apple apple;

    public Garden() {
        this.snake = new Snake(Settings.cellsAcross / 2, Settings.cellsDown / 2);
        this.apple = new Apple(new Tile(0, 0));
        placeApple();
    }

    public void reset() {
        this.snake = new Snake(Settings.cellsAcross / 2, Settings.cellsDown / 2);
        this.apple = new Apple(new Tile(0, 0));
        placeApple();
    }

    public Apple getApple() {
        return apple;
    }

    public Snake getSnake() {
        return snake;
    }

    public void placeApple() {
        Tile possible = new Tile(random.nextInt(Settings.cellsAcross), random.nextInt(Settings.cellsDown));
        while (snake.contains(possible)) {
            possible = new Tile(random.nextInt(Settings.cellsAcross), random.nextInt(Settings.cellsDown));
        }
        apple.setTile(possible);
    }
}
