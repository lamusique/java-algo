public class GammaRandom {
    public static double rnd1(int two_a) {
        double x = 1;
        for (int i = two_a / 2; i > 0; i--) x *= Math.random();
        x = - Math.log(x);
        if ((two_a & 1) != 0) { // two_a が奇数
            double r = NormalRandom.rnd();  x += 0.5 * r * r;
        }
        return x;
    }

    public static double rnd(double a) { // ガンマ分布の乱数，a > 0
        double x;
        if (a > 1) {
            double t = Math.sqrt(2 * a - 1), u, y;
            do {
                do {
                    do {
                        x = 1 - Math.random();  y = 2 * Math.random() - 1;
                    } while (x * x + y * y > 1);
                    y /= x;
                    x = t * y + a - 1;
                } while (x <= 0);
                u = (a - 1) * Math.log(x / (a - 1)) - t * y;
            } while (u < -50 || Math.random() > (1 + y * y) * Math.exp(u));
        } else {
            double t = Math.E / (a + Math.E), y;
            do {
                if (Math.random() < t) {
                    x = Math.pow(Math.random(), 1 / a);  y = Math.exp(-x);
                } else {
                    x = 1 - Math.log(Math.random());  y = Math.pow(x, a - 1);
                }
            } while (Math.random() >= y);
        }
        return x;
    }
}

