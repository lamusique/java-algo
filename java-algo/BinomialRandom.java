public class BinomialRandom {
    public static int rnd(int n, double p) {
        int r = 0;
        for (int i = 0; i < n; i++)
            if (Math.random() < p) r++;
        return r;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("usage: java BinomialRandom <n> <p>");
            return;
        }
        int n = Integer.parseInt(args[0]);
        double  p = Double.parseDouble(args[1]), q = 1 - p,
                s = Math.pow(q, n), t = s;
        if (s == 0) {
            System.err.println("n か p が大きすぎます");
            return;
        }
        NumberFormatter fmt1 = new NumberFormatter("4d"),
                        fmt2 = new NumberFormatter("7.4f");
        for (int k = 0; k < n; k++) {
            System.out.println(fmt1.toString(k) + " " + fmt2.toString(s));
            t *= (n - k) * p / ((k + 1) * q);
            s += t;
        }
        System.out.println(fmt1.toString(n) + " " + fmt2.toString(s));
    }
}

