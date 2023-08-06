public class TRandom {
    public static double rnd(double n) {
        if (n <= 2)
            return NormalRandom.rnd() / Math.sqrt(Chi2Random.rnd(n) / n);
        double a, b, c;
        do {
            a = NormalRandom.rnd();
            b = a * a / (n - 2);
            c = Math.log(1 - Math.random()) / (1 - 0.5 * n);
        } while (Math.exp(-b-c) > 1 - b);
        return a / Math.sqrt((1 - 2.0 / n) * (1 - b));
    }
}

