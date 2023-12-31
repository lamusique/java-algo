/**
 *  Lorenz.java -- Lorenz(ローレンツ)アトラクタ
 *  (DrawOneByOnePanel.java, Plotter.java を使う)
 *
 *  @version $Revision: 1.8 $, $Date: 2003/03/18 10:05:54 $
 */

import java.awt.*;

public class Lorenz extends DrawOneByOnePanel {
    static final int WIDTH = 400,  HEIGHT = WIDTH;
    static final double SCALE = WIDTH / 60;
    static final double A = 10.0,  B = 28.0,  C = 8.0 / 3,  D = 0.01;

    public Lorenz() {  super(WIDTH + 1, HEIGHT + 1, 0);  }

    synchronized public void drawSlowly(Graphics2D g) {
        g.translate(WIDTH / 2, HEIGHT);  g.scale(1, -1);  // 原点を真中下に
        Plotter pt = new Plotter(g);
        double x = 1,  y = 1,  z = 1;
        for (int k = 0; k < 3000; k++) {
            double dx = A * (y - x);
            double dy = x * (B - z) - y;
            double dz = x * y - C * z;
            x += D * dx;  y += D * dy;  z += D * dz;
            if (k > 100) {
                pt.drawTo(x * SCALE, z * SCALE);
                sleep(1);  // 表示して待つ
            } else pt.moveTo(x * SCALE, z * SCALE);
        }
    }

    public static void main(String[] args) {
        DrawOneByOnePanel p = new Lorenz();
        p.makeFrame("Lorenzアトラクタ");
    }
}
