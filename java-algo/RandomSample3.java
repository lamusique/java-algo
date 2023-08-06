/**
 *  無作為抽出
 *
 *  @version $Revision: 1.4 $, $Date: 2003/04/28 23:23:19 $
 */

import java.util.*;

public class RandomSample3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("使用法: java RandomSample3 n m");
            System.out.println("  n=母集団の大きさ m=標本の大きさ");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Random random = new Random();

        int s[] = new int[n];
        for (int i = n - m; i < n; i++) {
            int j = random.nextInt(i + 1);  // 0 <= j <= i
            if (s[j] == 0) s[j] = 1;
            else           s[i] = 1;
        }
        for (int i = 0; i < n; i++)
            if (s[i] != 0) System.out.print((i + 1) + " ");
        System.out.println();
    }
}
