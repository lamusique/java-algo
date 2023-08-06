public class WeibullRandom {
    public static double rnd(double alpha) {
        return Math.pow(- Math.log(1 - Math.random()), 1 / alpha);
    }
}

