public class PowerRandom {
    public static double rnd(int n) {
//      return Math.pow(Math.random(), 1.0 / (n + 1));
        double p = Math.random(), r;
        for (int i = 0; i < n; i++)
            if ((r = Math.random()) > p) p = r;
        return p;
    }
}

