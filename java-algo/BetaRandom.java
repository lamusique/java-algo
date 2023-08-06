public class BetaRandom {
    public static double rnd1(double a, double b) {
        double x, y;
        do {
            x = Math.pow(Math.random(), 1 / a);
            y = Math.pow(Math.random(), 1 / b);
        } while (x + y > 1);
        return x / (x + y);
    }

    public static double rnd(double a, double b) {
        double temp = GammaRandom.rnd(a);
        return temp / (temp + GammaRandom.rnd(b));
    }
}

