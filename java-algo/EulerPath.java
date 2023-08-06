/**
 *  一筆書き
 *
 *  @version $Revision: 1.3 $, $Date: 2003/04/28 23:23:15 $
 */

import java.io.*;
import java.util.*;

public class EulerPath {
    static int n, nEdge, solution;  // 点の数, 線の数, 解の番号
    static int[][] adjacent;  // 隣接行列
    static int[] position;

    public static void readGraph() throws IOException { // グラフ入力
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer t = new StringTokenizer(input.readLine());
        n = Integer.parseInt(t.nextToken());  // 点の数
        adjacent = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) adjacent[i][j] = 0;

        String s;
        while ((s = input.readLine()) != null) {
            t = new StringTokenizer(s);
            int i = Integer.parseInt(t.nextToken());
            int j = Integer.parseInt(t.nextToken());
            nEdge++;                       // 線の数
            adjacent[i][j]++;
            adjacent[j][i]++;  // 有向グラフならこの行は削除
        }
        position = new int[nEdge + 1];

        System.out.println("隣接行列:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(" " + adjacent[i][j]);
            System.out.println();
        }
    }

    static void visit(int edge, int i) {
        position[edge] = i;
        if (edge == nEdge) {
            System.out.print("解 " + (++solution) + ": ");
            for (i = 0; i <= nEdge; i++)
                System.out.print(" " + position[i]);
            System.out.println();
        } else {
            for (int j = 1; j <= n; j++) if (adjacent[i][j] > 0) {
                adjacent[i][j]--;
                adjacent[j][i]--;  // 有向グラフならこの行は削除
                visit(edge + 1, j);
                adjacent[i][j]++;
                adjacent[j][i]++;  // 有向グラフならこの行は削除
            }
        }
    }

    public static void main(String[] args) throws IOException {
        readGraph();  // 隣接行列を読む
        solution = 0;  visit(0, 1);  // 点1から出発
        if (solution == 0) System.out.println("解なし");
    }
}
