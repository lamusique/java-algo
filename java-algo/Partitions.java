/*
* Partitions.java -- 分割数
* @version $Revision: 1.2 $, $Date: 2002/11/18 06:12:41 $
*/

/**
*分割数を求めます。
*@see Change
*/

public class Partitions {
    static int p(int n, int k) {
        if (n < 0) return 0;
        if (n <= 1 || k == 1) return 1;

        int s = 0;
        for (int i = 1; i <= k; i++) s += p(n - i, i);
        return s;
    }

    static int number(int n) {
        return p(n, n);
    }
    /**
    *1 から 20 までの分割数を表示します。
    */
    public static void main(String[] args) {
        for (int x = 1; x <= 20; x++)
            System.out.println(x + " : " + number(x));
    }
}
