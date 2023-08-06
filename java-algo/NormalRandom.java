public class NormalRandom extends RandomPointDistribution {
    public static double rnd1() { // 正規分布１
        return Math.random() + Math.random() + Math.random()
             + Math.random() + Math.random() + Math.random()
             + Math.random() + Math.random() + Math.random()
             + Math.random() + Math.random() + Math.random() - 6;
    }

    private static boolean sw2 = true;
    private static double t, u;

    public static double rnd2() { // 正規分布２
        if (sw2) {
            sw2 = false;
            t = Math.sqrt(-2 * Math.log(1 - Math.random()));
            u = 2 * Math.PI * Math.random();
            return t * Math.cos(u);
        } else {
            sw2 = true;
            return t * Math.sin(u);
        }
    }

    private static boolean sw = true;
    private static double x, y, s;

    public static double rnd() { // 正規分布３
        if (sw) {
            sw = false;
            do {
                x = 2 * Math.random() - 1;
                y = 2 * Math.random() - 1;
                s = x * x + y * y;
            } while (s >= 1 || s == 0);  // s == 0 のチェックは用心のため [2003-06-07 s > 1 を s >=1 に訂正]
            s = Math.sqrt(-2 * Math.log(s) / s);
            return x * s;
        } else {
            sw = true;
            return y * s;
        }
    }

    public double random() { return rnd(); }
}
