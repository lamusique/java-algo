/*
 *  $Revision: 1.2 $, $Date: 2003/04/28 23:23:16 $
 *  百五減算
 */
import java.io.*;

public class Hyakugo {
    public static void main(String[] args) throws IOException {
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1 から 100 までの整数を１つ考えてください");
        System.out.print("それを 3 で割った余り? ");
        int a = Integer.parseInt(input.readLine());
        System.out.print("それを 5 で割った余り? ");
        int b = Integer.parseInt(input.readLine());
        System.out.print("それを 7 で割った余り? ");
        int c = Integer.parseInt(input.readLine());
        int x = (70 * a + 21 * b + 15 * c) % 105;
        System.out.println("あなたの考えた数は " + x + " でしょう!");
    }
}
