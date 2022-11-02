package birckbracker;

import java.awt.Font;

public class GameTheme implements AbstractTheme {
  public GameStage stage;

  public GameTheme (GameStage stage) {
    this.stage = stage;
  }

  protected Font textPlain (int size) {
    return new Font(this.fontName, Font.PLAIN, size);
  }
  protected Font textBold (int size) {
    return new Font(this.fontName, Font.BOLD, size);
  }

  public final Font title = this.textBold(30);
  public final Font subtitle = this.textPlain(25);
  public final Font body1  = this.textBold(20);
  public final Font body2 = this.textBold(22);
}