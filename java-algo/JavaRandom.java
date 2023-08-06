/**
 *  乱数
 *
 *  @version $Revision: 1.4 $, $Date: 2003/04/28 23:23:16 $
 */

public class JavaRandom {
    static final long MULTIPLIER = 0x5DEECE66DL;
    static final long ADDEND = 0xBL;
    static final long MASK = (1L << 48) - 1;
    long seed;

    public JavaRandom() { this(System.currentTimeMillis()); }
    public JavaRandom(long seed) { setSeed(seed); }

    synchronized public void setSeed(long seed) {  // 0 <= seed < 2^48
        this.seed = (seed ^ MULTIPLIER) & MASK;
    }

    synchronized int next(int bits) {  // 0 < bits <= 32
        seed = (seed * MULTIPLIER + ADDEND) & MASK;
        return (int)(seed >>> (48 - bits));
    }

    public int nextInt() { return next(32); }
    public long nextLong() { return ((long)(next(32)) << 32) + next(32); }
    public float nextFloat() { return next(24) / ((float)(1 << 24)); }
    public double nextDouble() {
        return (((long)next(26) << 27) + next(27)) / (double)(1L << 53);
    }

    public int nextInt(int n) {  // 0<n<2^31
        if (n <= 0)
            throw new IllegalArgumentException("n は正の数");
        if ((n & -n) == n)  // nが2の累乗
            return (int)((n * (long)next(31)) >> 31);

        int bits, val;
        do {
            bits = next(31);
            val = bits % n;
        } while (bits - val + (n - 1) < 0);
        return val;
    }

    public static void main(String[] args) {
        JavaRandom r = new JavaRandom(12345);
        for (int i = 0; i < 10; i++) System.out.println(r.nextInt());
    }
}
