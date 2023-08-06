public class CauchyRandom {
    public static double rnd() {
        double x, y;
        do {
            x = 1 - Math.random();  y = 2 * Math.random() - 1;
        } while (x * x + y * y > 1);
        return y / x;
    }
}

