public class FRandom {
    public static double rnd(double n1, double n2) {
        return (Chi2Random.rnd(n1) * n2) / (Chi2Random.rnd(n2) * n1);
    }
}

