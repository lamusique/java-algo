public class Atan extends FuncViewer {
    private static int N = 24; // 本文参照

    public static double atan(double x) { // アークタンジェント
        int sign = 0;
        if (x > 1)       { sign =  1;  x = 1 / x; }
        else if (x < -1) { sign = -1;  x = 1 / x; }
        double a = 0;
        for (int i = N; i >= 1; i--)
            a = (x * x * i * i) / (2 * i + 1 + a);
        if (sign > 0) return   Math.PI / 2 - x / (1 + a);
        if (sign < 0) return - Math.PI / 2 - x / (1 + a);
        /* else */    return                 x / (1 + a);
    }

    /* 以下は FuncViewer の abstract メソッドのオーバーライド */
    public String getName() { return "Arctan(x)"; }
    public double getValue(double x) { return atan(x); }
}

