/**
 *  無作為抽出
 *
 *  @version $Revision: 1.7 $, $Date: 2003/04/28 23:23:19 $
 */

import java.util.*;
import java.io.*;

public class RandomSample2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));
        if (args.length != 1) {
            System.out.println("使用法: java RandomSample2 m");
            System.out.println("  m=標本の大きさ");
            System.out.print("標準入力から母集団の要素(文字列)を読み込み, ");
            System.out.println("標準出力に標本の要素を出力します.");
            return;
        }
        int m = Integer.parseInt(args[0]);
        Random random = new Random();
        System.err.println("標本の大きさ = " + m);

        int n = 0;  String s[] = new String[m],  t;
        while ((t = input.readLine()) != null) {
            if (++n <= m) s[n - 1] = t;
            else {
                int i = random.nextInt(n);
                if (i < m) s[i] = t;
            }
        }
        System.err.println("母集団の大きさ = " + n);
        for (int i = 0; i < m && i < n; i++)
            System.out.println(s[i]);
    }
}
