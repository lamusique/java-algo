public class Chi2Random {
    public static double rnd1(int n) {
        double s = 0;
        for (int i = 0; i < n; i++) {
            double t = NormalRandom.rnd();  s += t * t;
        }
        return s;
    }

    public static double rnd(double n) {
        return 2 * GammaRandom.rnd(0.5 * n);
    }
}
