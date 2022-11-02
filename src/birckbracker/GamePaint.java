package birckbracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GamePaint {
    private GameTheme theme;
    private Graphics graphics;
    private int score;
    private int maxScore = 200;

    public GamePaint(Graphics graphics, GameTheme theme, int score) {
        this.graphics = graphics;
        this.theme = theme;
        this.score = score;
    }

    public void paintScene() {
        graphics.setColor(theme.scene);
        graphics.fillRect(1, 1, 692, 592);
    }

    public void paintSceneBorder() {
        graphics.setColor(theme.secondary);
        graphics.fillRect(0, 0, 3, 592);
        graphics.fillRect(0, 0, 692, 3);
        graphics.fillRect(691, 1, 3, 592);
    }

    public void setHidden() {
        graphics.setColor(theme.scene);
    }

    public void score(boolean hide){
        if (hide) {
            this.setHidden();
        } else {
            graphics.setColor(theme.sceneContrast);
        }
        
        graphics.setFont(theme.body2);
        graphics.drawString("Score: " + this.score + "/" + maxScore, 490, 30);
    }

    public void paddle(int posX, boolean hide) {
        if (hide) {
            this.setHidden();
        } else {
            graphics.setColor(theme.primary);
        }
        
        graphics.fillRect(posX, 550, 100, 8);
    }

    public void ballScore (int ballPosX, int ballPosY) {
        int _ballSize = 20;
        Color _color = theme.primary;

        if (this.score >= 50 && this.score < 100) {
            _ballSize = _ballSize + 1;
            _color = theme.secondary;
        } else if (this.score >= 100 && this.score < 150) {
            _ballSize = _ballSize + 2;
            _color = theme.secondaryContrast;
        } else if (this.score >= 150) {
            _ballSize = _ballSize + 3;
            _color = theme.warning;
        }

        graphics.setColor(_color);
        graphics.fillOval(ballPosX, ballPosY, _ballSize, _ballSize);
    }

    public void ballHiding(int ballPosX, int ballPosY) {
        graphics.setColor(theme.scene);
        graphics.fillOval(ballPosX, ballPosY, 20, 20);
    }

    public void ballGameStart(int ballPosX, int ballPosY) {
        graphics.setColor(theme.primary);
        graphics.fillOval(ballPosX, ballPosY, 20, 20);
    }

    public void ballGameOver(int ballPosX, int ballPosY) {
        // hiding the ball after game over
        graphics.setColor(theme.primary);
        graphics.fillOval(ballPosX, ballPosY, 23, 23);
    }

    public void messageGameWin () {
        graphics.setColor(theme.warning);
        graphics.setFont(theme.title);
        graphics.drawString("You Win! Score: " + this.score, 200, 300);
    }

    public void messageGameOver () {
        graphics.setColor(theme.warning);
        graphics.setFont(theme.title);
        graphics.drawString("Game over! Score: " + this.score, 200, 300);
    }

    public void messageGameRestart () {
        graphics.setColor(theme.secondary);
        graphics.setFont(theme.body1);
        graphics.drawString("Press Enter to Restart..", 230, 330);
    }

    public void messageGameStart (boolean hide) {
        if (hide) {
            graphics.setColor(theme.scene);
        } else {
            graphics.setColor(theme.secondary);
        }

        graphics.setFont(theme.subtitle);
        graphics.drawString("Press Enter/Left/Right Arrow to start the game!", 90, 350);
    }
}
