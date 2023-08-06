/**
 *  Euler (オイラー) の数
 *
 *  @version $Revision: 1.4 $, $Date: 2003/04/28 23:23:15 $
 */

public class EulerianNumbers {
    public static int eulerianNumbers(int n, int k) {  // ${\tt n} \ge 0$
        if (k == 0) return 1;
        if (k < 0 || k >= n) return 0;
        return (k + 1) * eulerianNumbers(n - 1, k)
             + (n - k) * eulerianNumbers(n - 1, k - 1);
    }

    private static String right(int num) {
        String s = "     " + num;
        return s.substring(s.length() - 6);
    }

    public static void main(String[] args) {
        System.out.print("  k");
        for (int k = 0; k <= 8; k++) System.out.print(right(k));
        System.out.print("\nn  ");
        for (int k = 0; k <= 8; k++) System.out.print("------");
        System.out.println();
        for (int n = 0; n <= 8; n++) {
            System.out.print(n + " |");
            for (int k = 0; k <= n; k++)
                System.out.print(right(eulerianNumbers(n, k)));
            System.out.println();
        }
    }
}
