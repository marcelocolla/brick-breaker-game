package birckbracker;

import java.awt.Color;

public class ThemeAlternativeImpl extends AbstractTheme {
    public ThemeAlternativeImpl () {
        this.scene = Color.white;
        this.sceneContrast = Color.cyan;
        this.primary = Color.orange;
        this.secondary = Color.cyan;
        this.secondaryContrast = Color.orange;
        this.warning = Color.yellow;

        this.bgImage = '2';
    }
}
