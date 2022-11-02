package birckbracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {  //KeyListener detecting arroy key and ActionListener for moving the ball 

    private boolean play = false;
    public int score = 0;

    private int totalBricks = 40;

    private Timer timer;
    private int delay = 9;

    private int playerX = 300;

    private int ballPosX = 290;
    private int ballPosY = 350;
    private int ballDirX = getRandomNumberForX();
    private int ballDirY = getRandomNumberForY();

    private GameTheme theme;
    private MapGenerator mapPlay;

    public GamePlay() {
        mapPlay = new MapGenerator(4, 10);
        theme = new GameTheme();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics graphics) {
        //background
        graphics.setColor(theme.scene);
        graphics.fillRect(1, 1, 692, 592);

        //drawing map of bricks
        mapPlay.draw((Graphics2D) graphics, theme.sceneContrast);

        //border
        graphics.setColor(theme.secondary);
        graphics.fillRect(0, 0, 3, 592);
        graphics.fillRect(0, 0, 692, 3);
        graphics.fillRect(691, 1, 3, 592);

        //score
        graphics.setColor(theme.sceneContrast);
        graphics.setFont(theme.body2);
        graphics.drawString("Score: " + score + "/200", 490, 30);

        //paddle
        graphics.setColor(theme.primary);
        graphics.fillRect(playerX, 550, 100, 8);

        if (play == false) {
            //game start message
            graphics.setColor(theme.secondary);
            graphics.setFont(theme.subtitle);
            graphics.drawString("Press Enter/Left/Right Arrow to start the game!", 90, 350);

            //ball hiding
            graphics.setColor(theme.scene);
            graphics.fillOval(ballPosX, ballPosY, 20, 20);
        } else {
            //ball showing
            graphics.setColor(theme.primary);
            graphics.fillOval(ballPosX, ballPosY, 20, 20);
        }

        if (score >= 50 && score < 100) {
            //ball color & size change
            graphics.setColor(theme.secondary);
            graphics.fillOval(ballPosX, ballPosY, 21, 21);
        } else if (score >= 100 && score < 150) {
            //ball
            graphics.setColor(theme.secondaryContrast);
            graphics.fillOval(ballPosX, ballPosY, 22, 22);
        } else if (score >= 150) {
            //ball
            graphics.setColor(theme.warning);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);
        }

        if (totalBricks <= 0) {
            play = false;
            ballDirX = 0;
            ballDirY = 0;

            //hiding the ball after game over
            graphics.setColor(theme.scene);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);

            graphics.setColor(theme.warning);
            graphics.setFont(theme.title);
            graphics.drawString("You Win! Score: " + score, 200, 300);

            graphics.setColor(theme.secondary);
            graphics.setFont(theme.body1);
            graphics.drawString("Press Enter to Restart..", 230, 330);

            //above score hiding
            graphics.setColor(theme.scene);
            graphics.setFont(theme.body2);
            graphics.drawString("Score: " + score + "/200", 490, 30);

            //hide remains bricks
            mapPlay.draw((Graphics2D) graphics, theme.scene);

            //paddle
            graphics.setColor(theme.scene);
            graphics.fillRect(playerX, 550, 100, 8);

            //game start message
            graphics.setColor(theme.scene);
            graphics.setFont(theme.subtitle);
            graphics.drawString("Press Enter/Left/Right Arrow to start the game!", 90, 350);
        }

        if (ballPosY > 570) { // if ball fall in down
            play = false;
            ballDirX = 0;
            ballDirY = 0;

            //hiding the ball after game over
            graphics.setColor(theme.scene);
            graphics.fillOval(ballPosX, ballPosY, 23, 23);

            graphics.setColor(theme.warning);
            graphics.setFont(theme.title);
            graphics.drawString("Game over! Score: " + score, 200, 300);

            graphics.setColor(theme.secondary);
            graphics.setFont(theme.body1);
            graphics.drawString("Press Enter to Restart..", 230, 330);

            //above score hiding
            graphics.setColor(theme.scene);
            graphics.setFont(theme.body2);
            graphics.drawString("Score: " + score + "/200", 490, 30);

            //hide remains bricks
            mapPlay.draw((Graphics2D) graphics, theme.scene);

            //paddle
            graphics.setColor(theme.scene);
            graphics.fillRect(playerX, 550, 100, 8);

            //game start message
            graphics.setColor(theme.scene);
            graphics.setFont(theme.subtitle);
            graphics.drawString("Press Enter/Left/Right Arrow to start the game!", 90, 350);
        }
        graphics.dispose();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
                playerX = 310;
                ballPosX = 290;
                ballPosY = 350;
                ballDirX = getRandomNumberForX();
                ballDirY = getRandomNumberForY();
                totalBricks = 40;

                mapPlay = new MapGenerator(4, 10);
                score = 0;

                repaint();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerX += 20;
    }

    public void moveLeft() {
        play = true;
        playerX -= 20;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();

        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballDirY = -ballDirY;
            }

            A:
            for (int i = 0; i < mapPlay.map.length; i++) {
                for (int j = 0; j < mapPlay.map[0].length; j++) {
                    if (mapPlay.map[i][j] > 0) {
                        int brickX = j * mapPlay.brickWidth + 80;
                        int brickY = i * mapPlay.brickHeight + 50;
                        int brickWidth = mapPlay.brickWidth;
                        int brickHeight = mapPlay.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                            mapPlay.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;

                            if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                ballDirX = -ballDirX;
                            } else {
                                ballDirY = -ballDirY;
                            }
                            break A;
                        }
                    }
                }
            }

            ballPosX += ballDirX;
            ballPosY += ballDirY;

            if (ballPosX < 0) {  //for left
                ballDirX = -ballDirX;
            }
            if (ballPosY < 0) { //for top
                ballDirY = -ballDirY;
            }
            if (ballPosX > 670) { //for right
                ballDirX = -ballDirX;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public int getRandomNumberForY() {
        Random random = new Random();
        int max = -1;
        int min = -5;
        int randomNumber = min + random.nextInt(max - min + 1);
        return randomNumber;
    }

    public int getRandomNumberForX() {
        Random random = new Random();
        int max = -1;
        int min = -3;
        int randomNumber = min + random.nextInt(max - min + 1);
        return randomNumber;
    }
}
