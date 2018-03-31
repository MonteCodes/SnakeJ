package monte.snake.view;

import monte.snake.model.Garden;
import monte.snake.model.Tile;
import monte.snake.util.Settings;

import javax.swing.*;
import java.awt.*;

public class GraphicalGarden extends JPanel {
    public GameState gameState;
    private Garden garden;

    public GraphicalGarden() {
        this.gameState = GameState.PAUSED;
    }

    public void updateGarden(Garden garden) {
        this.garden = garden;
    }

    public void run() {
        this.gameState = GameState.RUNNING;
        this.garden.reset();
    }

    public void lose() {
        this.gameState = GameState.GAME_OVER;
    }

    @Override
    public void paint(Graphics g) {
        drawBackground(g);
        drawGrid(g);
        if (gameState == GameState.RUNNING) {
            showScore(g);
            drawSnake(g);
            drawApple(g);
        } else if (gameState == GameState.GAME_OVER) {
            showGameOver(g);
            showPressKey(g);
        } else {
            showStartScreen(g);
            showPressKey(g);
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(Settings.backgroundColor);
        g.fillRect(0, 0, Settings.windowWidth, Settings.windowHeight);
    }

    private void drawSnake(Graphics g) {
        int tileSize = Settings.cellSize;
        int width = tileSize - 2;
        int height = tileSize - 2;
        g.setColor(Settings.snakeColor);
        for (Tile tile : garden.getSnake().getSegments()) {
            int x = tile.x * tileSize + 1;
            int y = tile.y * tileSize + 1;
            g.fillRect(x, y, width, height);
        }
    }

    private void drawApple(Graphics g) {
        int tileSize = Settings.cellSize;
        int x = garden.getApple().getTile().x * tileSize + 1;
        int y = garden.getApple().getTile().y * tileSize + 1;

        g.setColor(Settings.appleColor);
        g.fillRect(x, y, tileSize - 2, tileSize - 2);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.GRAY);
        for (int x = 0; x < Settings.windowWidth; x += Settings.cellSize) {
            g.drawLine(x, 0, x, Settings.windowHeight);
        }
        for (int y = 0; y < Settings.windowHeight; y += Settings.cellSize) {
            g.drawLine(0, y, Settings.windowWidth, y);
        }
    }

    private void showStartScreen(Graphics g) {
        String welcome = "Snake!";

        Font welcomeFont = new Font("Times New Roman", Font.BOLD, 60);
        FontMetrics welcomeMetrics = getFontMetrics(welcomeFont);

        g.setColor(Color.WHITE);
        g.setFont(welcomeFont);

        g.drawString(welcome, (Settings.windowWidth - welcomeMetrics.stringWidth(welcome)) / 2, Settings.windowHeight / 2);
    }

    private void showPressKey(Graphics g) {
        String press = "Press Any Key To Begin.";

        Font pressFont = new Font("Times New Roman", Font.BOLD, 30);
        FontMetrics pressMetrics = getFontMetrics(pressFont);

        g.setColor(Color.WHITE);
        g.setFont(pressFont);

        g.drawString(press, Settings.windowWidth - pressMetrics.stringWidth(press), Settings.windowHeight - 10);

    }

    private void showGameOver(Graphics g) {
        String gameOver = "Game Over!";

        Font gameOverFont = new Font("Times New Roman", Font.BOLD, 60);
        FontMetrics metrics = getFontMetrics(gameOverFont);

        g.setColor(Color.WHITE);
        g.setFont(gameOverFont);

        g.drawString(gameOver, (Settings.windowWidth - metrics.stringWidth(gameOver)) / 2, Settings.windowHeight / 2);
    }

    private void showScore(Graphics g) {
        String score = "Score: " + (garden.getSnake().getSegments().size() - 3);

        Font scoreFont = new Font("Times New Roman", Font.BOLD, 30);
        FontMetrics scoreMetrics = getFontMetrics(scoreFont);

        g.setColor(Color.WHITE);
        g.setFont(scoreFont);

        g.drawString(score, Settings.windowWidth - scoreMetrics.stringWidth(score), 30);

    }

    public GameState getGameState() {
        return gameState;
    }
}
