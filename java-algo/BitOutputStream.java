/**
 * BitOutputStream.java -- ビット出力ストリーム
 *
 * @version $Revision: 1.7 $, $Date: 2003/03/22 02:31:14 $
 */

import java.io.*;
/**
* Huffman法などで使うビット出力ルーチンです。
* @see BitInputStream
* @see Huffman
* @see Slide
* @see Squeeze
*/
public class BitOutputStream extends FilterOutputStream {
    public static final int MAX_BITS = 31;  // 書き込み可能な最大ビット数
    protected int putCount = 8; // ビット出力カウンタ
    protected int bitBuf = 0;   // ビット出力バッファ
    protected int outCount = 0; // バイト出力カウンタ
    /**
    * コンストラクタ
    * @param out 出力ストリーム
    */
    public BitOutputStream(OutputStream out) {  super(out);  }
    /**
    * 出力バイト数を返す
    */
    public int outCount() {  return outCount;  }
    /**
     * x の右側 n ビットを返す
     */
    private static int rightBits(int n, int x) {
         return x & ((1 << n) - 1);
    }
    /**
    * 1ビットを出力
    */
    public void putBit(boolean bit) throws IOException {
        putCount--;
        if (bit) bitBuf |= (1 << putCount);
        if (putCount == 0) {
            out.write(bitBuf);
            bitBuf = 0;  putCount = 8;  outCount++;
        }
    }
    /**
    * x の右側 n ビットを出力
    */
    public void putBits(int n, int x) throws IOException {
        while (n >= putCount) {
            n -= putCount;
            bitBuf |= rightBits(putCount, x >>> n);
            out.write(bitBuf);
            bitBuf = 0;  putCount = 8;  outCount++;
        }
        putCount -= n;
        bitBuf |= rightBits(n, x) << putCount;
    }
    /**
    * ストリームをクローズ
    */
    public void close() throws IOException {
        putBits(7, 0);  super.close();  // バッファをフラッシュ
    }
}
