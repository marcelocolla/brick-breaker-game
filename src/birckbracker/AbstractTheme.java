package birckbracker;

import java.awt.Color;
import java.awt.Font;

public interface AbstractTheme {
    String fontName = Font.SANS_SERIF;

    // Texts styles
    Font title = null;
    Font subtitle = null;
    Font body1 = null;
    Font body2 = null;

    // Colors styles
    Color scene = Color.pink;
    Color sceneContrast = Color.white;
    Color primary = Color.MAGENTA;
    Color secondary = Color.yellow;
    Color secondaryContrast = Color.orange;
    Color warning = Color.red;

    // Stage positions
    GameStage stage = null;
}
