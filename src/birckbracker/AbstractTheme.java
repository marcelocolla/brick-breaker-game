package birckbracker;

import java.awt.Color;
import java.awt.Font;

public class AbstractTheme {
    String fontName = Font.SANS_SERIF;

    // Texts styles
    Font title = null;
    Font subtitle = null;
    Font body1 = null;
    Font body2 = null;

    // Colors styles
    Color transparent = new Color(0xffffff);
    Color paddleBar = Color.white;
    Color scene = null;
    Color sceneContrast = null;
    Color primary = null;
    Color secondary = null;
    Color secondaryContrast = null;
    Color warning = null;

    // Stage positions
    GameStage stage = null;

    // Background
    char bgImage = '1';
}
