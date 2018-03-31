package monte.snake.controller;

import monte.snake.model.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {

    private Direction direction;

    public KeyboardManager() {
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            direction = Direction.LEFT;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            direction = Direction.RIGHT;
        }
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            direction = Direction.UP;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            direction = Direction.DOWN;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
