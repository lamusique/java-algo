public class ArcHyperbolic extends FuncViewer {
    private static double EPS5 = 0.001; // double 型の機械エプシロンの1/5乗程度

    public static double arcsinh(double x) { // arcsinh x
        if (x >  EPS5) return  Math.log(Math.sqrt(x * x + 1) + x);
        if (x < -EPS5) return -Math.log(Math.sqrt(x * x + 1) - x);
        return x * (1 - x * x / 6);
    }

    public static double arccosh(double x) { // arccosh x, x >= 1
        return Math.log(x + Math.sqrt(x * x - 1));
    }

    public static double arctanh(double x) { // arctanh x
        if (Math.abs(x) > EPS5) return 0.5 * Math.log((1 + x) / (1 - x));
        return x * (1 + x * x / 3);
    }

    /* 以下は FuncViewer の abstract メソッドのオーバーライド */
//  public String getName() { return "arcsinh(x)"; }
//  public double getValue(double x) { return arcsinh(x); }
    public String getName() { return "arccosh(x)"; }
    public double getValue(double x) { return arccosh(x); }
//  public String getName() { return "arctanh(x)"; }
//  public double getValue(double x) { return arctanh(x); }

}

