package birckbracker;

import java.awt.Color;

public class ThemeDefaultImpl extends AbstractTheme {
    public ThemeDefaultImpl () {
        this.scene = Color.white;
        this.sceneContrast = Color.white;
        this.primary = Color.PINK;
        this.secondary = Color.yellow;
        this.secondaryContrast = Color.orange;
        this.warning = Color.red;
    }
}
