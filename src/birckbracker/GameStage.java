package birckbracker;

public class GameStage {
  public int spacer;
  public int width;
  public int maxWidth;
  public int ballFallInDown;
  public int posYBase;

  public GameStage(int width, int spacer) {
    this.width = width;
    this.maxWidth = width + 100;
    this.posYBase = width / 2;
    this.spacer = spacer;
    this.ballFallInDown = width - spacer;
  }

  public int calcPosition(int scale) {
    return this.posYBase + (this.spacer * scale);
  }

  // ball
  public final int ballSize = 20;

  // title
  public final int drawTitleX () {
    return 200;
  }

  public final int drawTitleY () {
    return this.width / 2;
  }

  // subtitle
  public final int drawMessageX () {
    return 230;
  };
  public final int drawMessageY () {
    return this.calcPosition(1);
  }

  // subtitle
  public final int drawSubtitleX () {
    return 90;
  };
  public final int drawSubtitleY () {
    return this.calcPosition(2);
  };
}