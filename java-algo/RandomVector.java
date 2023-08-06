public class RandomVector {
    public static void rnd1(double[] v) {
        int n = v.length;
        double r;
        do {
            r = 0;
            for (int i = 0; i < n; i++) {
                v[i] = 2 * Math.random() - 1;  r += v[i] * v[i];
            }
        } while (r > 1);
        r = Math.sqrt(r);
        for (int i = 0; i < n; i++) v[i] /= r;
    }

    public static void rnd2(double[] v) {
        int n = v.length;
        double r = 0;
        for (int i = 0; i < n; i++) {
            v[i] = NormalRandom.rnd();  r += v[i] * v[i];
        }
        r = Math.sqrt(r);
        for (int i = 0; i < n; i++) v[i] /= r;
    }
}

