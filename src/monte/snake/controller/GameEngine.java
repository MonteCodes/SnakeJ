package monte.snake.controller;

import monte.snake.model.Direction;
import monte.snake.model.Garden;
import monte.snake.model.Tile;
import monte.snake.util.Settings;
import monte.snake.view.GUI;

import java.util.concurrent.TimeUnit;

public class GameEngine {

    private Garden garden;
    private GUI gui;

    public GameEngine(GUI gui) {
        this.gui = gui;
        this.garden = new Garden();
    }

    public void play() {
        Event event = null;
        long start, elapsed, wait;

        while (true) {
            start = System.nanoTime();

            event = step();
            gui.update(garden, event);

            elapsed = System.nanoTime() - start;
            wait = TimeUnit.NANOSECONDS.toMillis(((TimeUnit.SECONDS.toNanos(1)/Settings.speed) - elapsed));

            if (wait < 0) {
                wait = 5;
            }
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Event step() {
        Event.Builder builder = new Event.Builder();
        if (isGameWon()) {
            builder.win(true);
        } else if (canMove()) {
            garden.getSnake().move();
            builder.direction(gui.getDirection());

            if (garden.getSnake().getHead().equals(garden.getApple().getTile())) {
                garden.placeApple();
                builder.ateFood(true);
            } else {
                garden.getSnake().removeTail();
            }
        } else {
            builder.loss(true);
        }
        return builder.build();
    }

    private boolean isGameWon() {
        return garden.getSnake().getSegments().size() == (Settings.cellsAcross * Settings.cellsDown);
    }

    private boolean canMove() {
        Direction d = garden.getSnake().getDirection();
        Tile head = garden.getSnake().getHead();
        if (head.x + d.x < 0 || head.x + d.x >= Settings.cellsAcross || head.y + d.y < 0 || head.y + d.y >= Settings.cellsDown) {
            return false;
        }
        if (garden.getSnake().contains(move(head, d)) && !garden.getSnake().getTail().equals(move(head, d))) {
            return false;
        }
        return true;
    }

    private Tile move(Tile tile, Direction d) {
        return new Tile(tile.x + d.x, tile.y + d.y);
    }
}
