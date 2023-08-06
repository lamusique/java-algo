/**
 * MeanSD3.java -- 平均値・標準偏差3
 * @version $Revision: 1.4 $, $Date: 2003/01/24 13:40:37 $
 */

import java.io.*;

class MeanSD3 {
    public static void main(String[] args) {
        BufferedReader in = new
            BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        double s1 = 0, s2 = 0;
        try {
            while (true) {
                double x = Double.parseDouble(in.readLine());
                n++;            // 個数
                x -= s1;        // 仮平均との差
                s1 += x / n;    // 平均
                s2 += (n - 1) * x * x / n; // 平方和
            }
        } catch (Exception e) {
        }
        s2 = Math.sqrt(s2 / (n - 1)); // 標準偏差
        System.out.println("個数: " + n + "  平均: " + s1
                           + "  標準偏差: " + s2);
    }
}
