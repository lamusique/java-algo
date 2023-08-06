public class PoissonRandom {
    public static int rnd(double lambda) {
        lambda = Math.exp(lambda) * Math.random();
        int k = 0;
        while (lambda > 1) {
            lambda *= Math.random();  k++;
        }
        return k;
    }
}

