package birckbracker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

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

    private Image getImage(String path) {
        URL imageURL = getClass().getResource(path);

        if (imageURL == null)
            return null;

        return new ImageIcon(imageURL).getImage();
    }

    public void paintScene() {
        Image img = this.getImage("background-" + theme.bgImage + ".jpg");

        graphics.setColor(theme.scene);
        graphics.fillRect(1, 1, theme.stage.maxWidth, theme.stage.width);
        graphics.drawImage(img, 0, 0, null);
    }

    public void paintSceneBorder() {
        int calcWidth = theme.stage.maxWidth + 5;

        graphics.setColor(theme.secondary);
        graphics.fillRect(0, 0, 3, theme.stage.width);
        graphics.fillRect(0, 0, calcWidth, 3);
        graphics.fillRect(calcWidth, 1, 3, theme.stage.width);
    }

    public void setHidden() {
        graphics.setColor(theme.transparent);
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
            graphics.setColor(theme.paddleBar);
        }
        
        graphics.fillRect(posX, 550, 100, 8);
    }

    public void ballScore (int ballPosX, int ballPosY) {
        int _ballSize = theme.stage.ballSize;
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
        graphics.fillOval(ballPosX, ballPosY, theme.stage.ballSize, theme.stage.ballSize);
    }

    public void ballGameStart(int ballPosX, int ballPosY) {
        graphics.setColor(theme.primary);
        graphics.fillOval(ballPosX, ballPosY, theme.stage.ballSize, theme.stage.ballSize);
    }

    public void ballGameOver(int ballPosX, int ballPosY) {
        // hiding the ball after game over
        graphics.setColor(theme.primary);
        graphics.fillOval(ballPosX, ballPosY, theme.stage.ballSize, theme.stage.ballSize);
    }

    public void messageGameWin () {
        graphics.setColor(theme.warning);
        graphics.setFont(theme.title);
        graphics.drawString("Você Venceu! Score: " + this.score, theme.stage.drawTitleX(), theme.stage.drawTitleY());
    }

    public void messageGameOver () {
        graphics.setColor(theme.warning);
        graphics.setFont(theme.title);
        graphics.drawString("Fim de jogo! Score: " + this.score, theme.stage.drawTitleX() - 20, theme.stage.drawTitleY());
    }

    public void messageGameRestart () {
        graphics.setColor(theme.secondary);
        graphics.setFont(theme.body1);
        graphics.drawString("Pressione Enter para reiniciar", 190, theme.stage.drawMessageY());
    }

    public void messageGameStart (boolean hide) {
        Image img = this.getImage("cenarios.png");

        if (hide) {
            graphics.setColor(theme.transparent);
        } else {
            graphics.setColor(theme.secondary);
        }

        graphics.drawImage(img, 200, 72, null);

        graphics.setFont(theme.title);
        graphics.drawString("Pressione Enter para iniciar o jogo!", 60, theme.stage.drawTitleY() + 16);

        graphics.setFont(theme.subtitle);
        graphics.drawString("Use as setas Esquerda/Direita para jogar!", 100, theme.stage.drawSubtitleY());
    }
}
