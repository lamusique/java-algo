public class GeometricRandom {
    public static int rnd1(double p) {
        int n = 1;
        while (Math.random() > p) n++;
        return n;
    }

    public static int rnd2(double p) {
        return (int)Math.ceil(Math.log(1 - Math.random()) / Math.log(1 - p));
    }
}

