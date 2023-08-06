/*
 *  Legendre 記号
 *  @version $Revision: 1.5 $, $Date: 2003/03/20 03:44:45 $
 */
import java.math.BigInteger;

class LegendreSymbol {
    static final BigInteger ZERO = BigInteger.ZERO;
    static final BigInteger ONE = BigInteger.ONE;

    static int calc(BigInteger a, BigInteger p) throws Exception {
        BigInteger x = a, y = p;
        int z = 1;
        for (;;) {
            // (-x/y) = (-1/y)(x/y) と第一補充法則
            if (y.compareTo(ZERO) == 0) throw new Exception("value error");
            x = x.mod(y);
            if (x.compareTo(ZERO) == 0) return 0;
            if (x.add(x).compareTo(y) > 0) {
                x = y.subtract(x);
                if ((y.intValue() & 3) == 3) z = -z;
            }
            // (2^{2n}x/y) = (x/y)
            while ((x.intValue() & 3) == 0) {
                x = x.shiftRight(2);
            }
            if (!x.testBit(0)) {
                x = x.shiftRight(1);
                // 第二補充法則
                int tmp = y.intValue() & 7;
                if (tmp == 3 || tmp == 5) z = -z;
            }
            if (x.compareTo(ONE) == 0) return z;
            // 相互法則
            if ((x.intValue() & 3) == 3 && (y.intValue() & 3) == 3) {
                z = -z;
            }
            BigInteger tmp = y;  y = x;  x = tmp;
        }
    }
    static int calc(long a, long p) throws Exception {
        return calc(BigInteger.valueOf(a), BigInteger.valueOf(p));
    }
    static public void main(String[] argv) throws Exception {
        System.out.println("ret="+ calc(7001, 8009));
    }
}
