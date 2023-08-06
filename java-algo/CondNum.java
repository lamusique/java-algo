/*
* CondNum.java -- 条件数
* @version $Revision: 1.4 $, $Date: 2003/03/13 14:24:31 $
* class RMatrix, LUMatInv, LU を使う。
*/

import java.io.*;

/**
* 行列の条件数を求めます。
* @see LUMatInv
* @see RMatrix
*/
public class CondNum {
    static double infinityNorm(double[][] a) { // ∞ノルム
        int n = a.length;
        double max = 0;
        for (int i = 0; i < n; i++) {
            double rowSum = 0;
            for (int j = 0; j < n; j++) rowSum += Math.abs(a[i][j]);
            if (rowSum > max) max = rowSum;
        }
        return max;
    }
    /**
    * 行列の条件数を求めます。
    * @param a 条件数を求めたい行列 <code>a[0..n-1][0..n-1]</code> を与えます。
    * @return 行列 <code>a[][]</code> の条件数を返します。
    */
    public static double getValue(double[][] a) { // 条件数
        int n = a.length;
        double[][] aInv = new double[n][n];
        double t = infinityNorm(a);

        if (LUMatInv.inverse(a, aInv) == 0)  // mathutils.LUMatInv
            throw new Error("逆行列がありません");
        return t * infinityNorm(aInv);
    }
    /**
    * 乱数を使ったテストプログラムです。<br>
    * 最初に行列の次数 n を入力します。
    */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new
            BufferedReader(new InputStreamReader(System.in));

        System.out.print("行列の次数 n = ");
        int n = Integer.parseInt(in.readLine());    // 行列の次数を入力
        double[][] a = new double[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = Math.random() - Math.random();

        RMatrix.print(a, 7, "10.6f");
        System.out.println("条件数 = " + getValue(a));
    }
}
