package monte.snake.view;

import monte.snake.controller.KeyboardManager;
import monte.snake.model.Direction;
import monte.snake.controller.Event;
import monte.snake.model.Garden;
import monte.snake.util.Settings;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {
    private KeyboardManager directionManager;
    private GraphicalGarden garden;

    public GUI() {
        directionManager = new KeyboardManager();
        KeyManager keyManager = new KeyManager();
        garden = new GraphicalGarden();
        garden.setPreferredSize(new Dimension(Settings.windowWidth, Settings.windowHeight));

        JFrame frame = new JFrame("Snake!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(garden);
        frame.pack();
        frame.setVisible(true);

        garden.addKeyListener(directionManager);
        garden.addKeyListener(keyManager);

        frame.addKeyListener(directionManager);
        frame.addKeyListener(keyManager);

        garden.setFocusable(true);
        frame.setFocusable(true);
    }

    public void repaint() {
        garden.repaint();
    }

    public void update(Garden g, Event e) {
        if (garden.gameState == GameState.RUNNING) {
            garden.updateGarden(g);
            if (e.loss) {
                garden.lose();
            }
            repaint();

            if (e.moved) {
                g.getSnake().changeDirection(directionManager.getDirection());
            }
        }
    }

    public Direction getDirection() {
        return directionManager.getDirection();
    }

    private class KeyManager implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            try {
                if (garden.gameState != GameState.RUNNING) {
                    garden.run();
                }
            } catch (NullPointerException ignored) {
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
