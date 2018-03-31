package monte.snake.test;

import monte.snake.controller.GameEngine;
import monte.snake.view.GUI;

public class Test {

    public static void main(String[] args) {
        GUI gui = new GUI();
        GameEngine gameEngine = new GameEngine(gui);
        gameEngine.play();
    }
}
