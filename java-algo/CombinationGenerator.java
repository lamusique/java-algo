/**
 *  組合せの生成
 *
 *  @version $Revision: 1.3 $, $Date: 2003/04/28 23:23:15 $
 */

public class CombinationGenerator {
    final int n;  long x;

    public CombinationGenerator(int n, int k) {
        this.n = n;
        x = lowBit(k);
    }

    long lowBit(int n) {  // 下位 n ビットが1
        return (1L << n) - 1;
    }

    public boolean next() {
        long smallest = x & -x;
        long ripple = x + smallest;
        long new_smallest = ripple & -ripple;
        long ones = ((new_smallest / smallest) >> 1) - 1;
        x = ripple | ones;
        return (x & ~lowBit(n)) == 0;  // false で完了
    }

    public String toString() {
        String s = "";  long y = x;
        for (int i = 1; i <= n; i++) {
            if ((y & 1) == 1) s += " " +  i;
            y >>>= 1;
        }
        return s;
    }

    public static void main(String[] args) {
        CombinationGenerator c = new CombinationGenerator(8, 4);
        int count = 0;
        do {
            System.out.println((++count) + ":" + c);
        } while (c.next());
    }
}
