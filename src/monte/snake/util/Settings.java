package monte.snake.util;

import java.awt.*;

public class Settings {
    public static int cellSize = 40;
    public static int windowWidth = 1200;
    public static int windowHeight = 800;
    public static int cellsAcross = windowWidth / cellSize;
    public static int cellsDown = windowHeight / cellSize;
    public static Color backgroundColor = Color.BLACK;
    public static Color snakeColor = Color.GREEN;
    public static Color appleColor = Color.RED;
    public static int speed = 10;
}
