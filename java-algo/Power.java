/**
 * Power.java -- 累乗
 *
 * @version $Revision: 1.4 $, $Date: 2003/03/02 06:44:58 $
 */

import java.io.*;
import java.math.*;

public class Power {
    /** 整数乗 */
    public static double power(double x, int n) {
        int absN = Math.abs(n);
        double r = 1.0;

        while (absN != 0) {
            if ((absN & 1) != 0) r *= x;
            x *= x;  absN >>= 1;
        }
        return (n >= 0) ? r : 1 / r;
    }

    /** 累乗 */
    public static double power(double x, double y) {
        if (y <=  Integer.MAX_VALUE &&
            y >= -Integer.MAX_VALUE && y == (int)y)
            return power(x, (int)y);
        if (x > 0) return Math.exp(y * Math.log(x));
        if (x != 0 || y <= 0)
            throw new ArithmeticException("domain error");
        return 0;
    }

    /** テスト用 */
    public static void main(String[] args) throws IOException {
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));
        System.out.print("x = ");
        double x = Double.parseDouble(input.readLine());
        System.out.print("y = ");
        double y = Double.parseDouble(input.readLine());
        System.out.println("power(" + x + ", " + y + ") = " + power(x, y));
    }
}
