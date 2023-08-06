public class LogisticRandom {
    public static double rnd() {
        double r = Math.random();
        return Math.log(r / (1 - r));
    }
}

