/*
* BinarySplitE.java -- binary splitting method による e の計算
* @version $Revision: 1.3 $, $Date: 2003/05/12 10:24:55 $
*/
import java.math.*;

/**
*binary splitting 法を使って自然対数の底 e を BigDecimal で計算します。<br>
*配列を使った素直な方法を使用しています。
* @see BinarySplit1
* @see BinarySplitPi2
*/

public class BinarySplitE extends BinarySplit1 {
    BinarySplitE(int L, int f) { super(L, f); }

    public BigDecimal bsA(int k) { return BDTools.ONE; }
    public BigDecimal bsB(int k) { return BDTools.ONE; }
    public BigDecimal bsC(int k) { return BigDecimal.valueOf(k + 1); }
    public BigDecimal getValue() {
        set();  putTogether();
    // e - 1 = 1/1! + 1/2! + 1/3! + .... が求まっているから1を加える。
        return getValue(false).add(BDTools.ONE); // class BinarySplit1 の getValue()
    }

    public static void main(String[] args) {
        final int L = 1024;  // L = 2^p
        int f = (int)(L * Math.log(L / Math.E) / Math.log(10)) + 10;
        BinarySplitE e = new BinarySplitE(L, f);

        long start = System.currentTimeMillis();
        BigDecimal result = e.getValue();
        long time = System.currentTimeMillis() - start;

        System.out.println("----- 計算終了，出力準備中 -----");
        System.out.print("e = ");
        start = System.currentTimeMillis();
        result = BDTools.roundOff(result, f);
        BDTools.precision = f;   BDTools.print(result, 10); // 時間がかかる
//        System.out.println(result); // 速い
        long outTime = System.currentTimeMillis() - start;
        System.out.println("出力時間 : " + outTime + "(ms)");
        System.out.print("出力桁数 = " + BDTools.decNumber + ", f = " + f);
        System.out.print("  計算時間 : " + time + "(ms)");
        System.out.println("  項数 : " + e.upTo());
/* // MultiPrecision.e() と比較したい場合はここを生かす。
        int fm = (int)(f * Math.log(10) / Math.log(MultiPrecision.RADIX));
        MultiPrecision m = new MultiPrecision(fm);
        start = System.currentTimeMillis();
        String ms = m.toString(m.e());  // 基数変換を含む
        time = System.currentTimeMillis() - start;
        BigDecimal me = new BigDecimal(ms), d;
        d = result.subtract(me);
        System.out.print("MultiPrecision.e() の計算時間 : " + time + "(ms)  ");
        System.out.println("diffrence = " + BDTools.toDoubleString(d));
*/
    }
}
