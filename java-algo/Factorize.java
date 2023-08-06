/**
 *  素因数分解
 *
 *  @version $Revision: 1.4 $, $Date: 2003/04/28 23:23:15 $
 */

public class Factorize {
    static void factorize(int x) {
        System.out.print(x + " = ");
        while (x >= 4 && x % 2 == 0) {
            System.out.print("2 * ");  x /= 2;
        }
        int i = 3;
        while (i * i <= x)
            if (x % i != 0) i += 2;
            else { System.out.print(i + " * ");  x /= i; }
        System.out.println(x);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) factorize(i);
    }
}
