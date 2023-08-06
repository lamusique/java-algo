/**
 *  逆写像ソート
 *
 *  @version $Revision: 1.5 $, $Date: 2003/03/05 18:02:42 $
 */

import java.util.ArrayList;

public class MapSort1 {
    /** a[] を昇順に整列 (Vector 使用) */
    public static void sort(int a[], int min, int max) {
        ArrayList[] index = new ArrayList[max - min + 1];
        for (int x = 0; x <= max - min; x++)
            index[x] = new ArrayList();
        for (int i = 0; i < a.length; i++)
            index[a[i] - min].add(new Integer(a[i]));
        int j = 0;
        for (int x = 0; x <= max - min; x++)
            for (int i = 0; i < index[x].size(); i++)
                a[j++] = ((Integer)index[x].get(i)).intValue();
    }

    public static void main(String[] args) {
        final int N = 20;
        int[] a = new int[N];

        System.out.print("Before:");
        for (int i = 0; i < N; i++) {
            a[i] = (int)(Math.random() * 100);
            System.out.print(" " + a[i]);
        }
        System.out.println();
        sort(a, 0, 100);
        System.out.print("After: ");
        for (int i = 0; i < N; i++) System.out.print(" " + a[i]);
        System.out.println();
    }
}
