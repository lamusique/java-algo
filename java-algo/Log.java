// 要 Exp クラス (Exp.ldexp(x,k) = 2^k x を求めるために利用)

public class Log extends FuncViewer {
    private static double
        LOG2  = 0.693147180559945309417232121458; // log_e 2
    private static double
        SQRT2 = 1.41421356237309504880168872421; // sqrt(2)

    // C/C++ ライブラリ関数 t = frexp(x,&k) (x = 2^k t) の Java 版
    public static class Frexp {
        private static double
            bias = Double.longBitsToDouble(0x3ca0000000000000L); // 2^-52
        public double t; public int k;
        public Frexp(double x) {
            long bits = Double.doubleToLongBits(x);
            k = (int)((bits >> 52) & 0x7ffL);
            int s = (bits & 0x8000000000000000L) != 0 ? -1 : 1;
            bits &= 0xfffffffffffffL;
            if (k != 0) bits |= 0x10000000000000L; // 正規数
            t = bits * s * bias;
            k -= 1022;
        }
    }

    public static double log(double x) { // 自然対数（級数展開版）
        if (x <= 0) return Double.NaN;
        Frexp frexp = new Frexp(x / SQRT2);
            // 2^(frexp.k-1) <= x/sqrt(2) < 2^frexp.k
        x /= Exp.ldexp(1, frexp.k); // x -> x / 2^frexp.k
        x = (x - 1) / (x + 1);
        double x2 = x * x, s = x, last;
        int i = 1;
        do {
            x *= x2;  i += 2;  last = s;  s += x / i;
        } while (last != s);
        return LOG2 * frexp.k + 2 * s;
    }

    private static int N = 9; // 本文参照

    public static double log_cf(double x) { // 自然対数（連分数版）
        if (x <= 0) return Double.NaN;
        Frexp frexp = new Frexp(x / SQRT2);
        x /= Exp.ldexp(1, frexp.k);  x--;
        double s = 0;
        for (int i = N; i >= 1; i--)
            s = i * x / (2 + i * x / (2 * i + 1 + s));
        return LOG2 * frexp.k + x / (1 + s);
    }

    /* 以下は FuncViewer の abstract メソッドのオーバーライド */
    public String getName() { return "log(x)"; }
    public double getValue(double x) { return log(x); }
}

