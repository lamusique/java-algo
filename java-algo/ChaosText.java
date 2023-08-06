/*
* ChaosText.java -- カオスとアトラクタ（テキスト出力版）
* @version $Revision: 1.2 $, $Date: 2002/10/26 04:21:45 $
*/
import java.io.*;
import java.text.*; // DecimalFormat を使う。

/**
* カオスとアトラクタのテキスト版です。
*/
public class ChaosText {
    /**
    * カオスとアトラクタのテキスト版です。
    * 最初に比例定数と初期値を入力します。
    */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new
            BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("   0.000");

        System.out.print("比例定数: ");
        double k = Double.parseDouble(in.readLine());
        System.out.print("初期値  : ");
        double p = Double.parseDouble(in.readLine());

        for (int i = 1; i <= 100; i++) {
            System.out.print(df.format(p));
            if (i % 4 == 0) System.out.println();
            p += k * p * (1 - p);
        }
    }
}
