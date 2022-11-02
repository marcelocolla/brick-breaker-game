package birckbracker;

import java.awt.Color;
import java.awt.Font;

//  implements AbstractTheme
public class GameTheme {
  protected final String FONT_NAME = Font.SANS_SERIF;

  // Colors styles
  public final Color scene = Color.pink;
  public final Color sceneContrast = Color.white;
  public final Color primary = Color.MAGENTA;
  public final Color secondary = Color.yellow;
  public final Color secondaryContrast = Color.orange;
  public final Color warning = Color.red;

  // Texts styles
  protected final Font textPlain (int size) {
    return new Font(this.FONT_NAME, Font.PLAIN, size);
  }
  protected final Font textBold (int size) {
    return new Font(this.FONT_NAME, Font.BOLD, size);
  }

  public final Font title = this.textBold(30);
  public final Font subtitle = this.textPlain(25);
  public final Font body1  = this.textBold(20);
  public final Font body2 = this.textBold(22);
}