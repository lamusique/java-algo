/**
 *  FiveNumber.java -- 五数要約
 *
 *  @version $Revision: 1.5 $, $Date: 2003/03/31 14:46:11 $
 */

import java.util.*;
import java.io.*;

/**
 * 五数要約を表示します。
 */
public class FiveNumber {
    static void print(double x[]) {
        Arrays.sort(x);  // 昇順に整列 $O(n \log n)$
        int n = x.length;

        for (int i = 0; i < 4; i++) {
            double t = (n - 1.0) * i / 4.0;  int j = (int)t;
            System.out.print( (x[j] + (x[j + 1] - x[j]) * (t - j)) + " ");
        }
        System.out.println(x[n - 1]);
    }

    /**
     * 複数個の倍精度実数を enter キーで区切って入力すると
     * ソートした五数要約を表示します。
     * ソートにはライブラリの調整されたクイックソート Arrays.sort(double[])
     * を使っています。
     * @see Contain
     * @see InputDoubleData
     */
    public static void main(String[] args) throws IOException {
        InputDoubleData data = new InputDoubleData(true);
        System.out.println("複数個の実数データを入力してください。");
        double[] x = data.getValue();

        print(x);
    }
}
