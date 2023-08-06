/**
 *  分布数えソート
 *
 *  @version $Revision: 1.11 $, $Date: 2002/05/21 06:18:34 $
 */

public class CountingSort {
    /** a[] を昇順に整列して b[] に書き込む */
    public static void sort(int a[], int b[], int min, int max) {
        int[] count = new int[max - min + 1];

        for (int i = 0; i <= max - min; i++) count[i] = 0;
        for (int i = 0; i < a.length; i++) count[a[i] - min]++;
        for (int i = 1; i <= max - min; i++) count[i] += count[i - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            int j = --count[a[i] - min];  b[j] = a[i];
        }
    }

    public static void main(String[] args) {
        final int N = 20;
        int[] a = new int[N];
        int[] b = new int[N];

        System.out.print("Before:");
        for (int i = 0; i < N; i++) {
            a[i] = (int)(Math.random() * 100);
            System.out.print(" " + a[i]);
        }
        System.out.println();
        sort(a, b, 0, 100);
        System.out.print("After: ");
        for (int i = 0; i < N; i++) System.out.print(" " + b[i]);
        System.out.println();
    }
}
