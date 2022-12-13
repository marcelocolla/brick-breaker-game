package birckbracker;

import java.awt.Color;

public class ThemeAlternativeImpl extends AbstractTheme {
    public ThemeAlternativeImpl () {
        this.scene = Color.white;
        this.sceneContrast = Color.cyan;
        this.primary = Color.PINK;
        this.secondary = Color.cyan;
        this.secondaryContrast = Color.PINK;
        this.warning = Color.orange;

        this.bgImage = '2';
    }
}
