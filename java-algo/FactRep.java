/**
 * FactRep.java -- 階乗進法
 *
 * @version $Revision: 1.7 $, $Date: 2003/03/03 22:33:32 $
 */

public class FactRep {
    /**
     * 0 から (n + 1)! - 1 までの整数を階乗進法で書き出します。
     */
    static void printAll(int n) {
        int i = 0,  j,  c[] = new int[n + 2];
        for (j = 1; j <= n + 1; j++) c[j] = 0;  // c[n+1] は番人
        do {
            String s = (i++) + " :";
            for (j = n; j >= 1; j--) s += " " + c[j];
            System.out.println(s);
            for (j = 1; c[j] == j; j++) c[j] = 0;
            c[j]++;
        } while (j <= n);
    }

    public static void main(String[] args) {
        printAll(4);
    }
}
