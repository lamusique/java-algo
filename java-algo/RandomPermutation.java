/**
 *  ランダムな順列
 *
 *  @version $Revision: 1.4 $, $Date: 2003/04/28 23:23:19 $
 */

import java.util.*;

public class RandomPermutation {
    static void shuffle(int a[]) {
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);  // 0 <= j <= i
            int swap = a[i];  a[i] = a[j];  a[j] = swap;
        }
    }

    static void randomPerm(int a[]) {
        for (int i = 0; i < a.length; i++) a[i] = i + 1;
        shuffle(a);
    }

    public static void main(String[] args) {
        int a[] = new int[100];
        randomPerm(a);
        for (int i = 0; i < 100; i++) System.out.print(a[i] + " ");
        System.out.println();
    }
}
