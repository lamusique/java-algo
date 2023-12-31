import java.io.*;

/**
 *  多変量データ読込み関係ルーチン集
 *
 *  @version $Revision: 1.4 $, $Date: 2003/03/13 14:24:36 $
 */
public class StatData {
    /**
     *  読込みエラーが生じた時に投げられる例外
     */
    public class ReadError extends RuntimeException {}

    private Reader input;
    private StreamTokenizer in;
    private int nRows, nCols;

    /**
     *  データファイルを読むために開き，最初にあるはずの件数 n，
     *  変量の数 m を読み込む。
     *
     *  @param  filename    データファイル名
     *  @throw #ReadError
     *  @throw #MissingData
     */
    public StatData(String filename) {
        try {
            input = new FileReader(filename);
        } catch (FileNotFoundException e) { throw new ReadError(); }
        in = new StreamTokenizer(input);
        double x = getNum(), y = getNum();
        if (x <= 0 || x > Integer.MAX_VALUE ||
            y <= 0 || y > Integer.MAX_VALUE) {
            System.err.println("行数・列数が読み込めません。");
            close(); throw new ReadError();
        }
        nRows = (int)x; nCols = (int)y;
        System.err.println(nRows + " 行 "
                         + nCols + " 列のデータです。");
    }
    /**
     *  データファイルの読込みを終了する。
     */
    public void close() { try { input.close(); } catch (Exception e) {} }
    /**
     *  件数を返す。
     *
     *  @return 件数
     */
    public int numberOfRows() { return nRows; }
    /**
     *  変量の数を返す。
     *
     *  @return 件数
     */
    public int numberOfColumns() { return nCols; }
    /**
     *  データファイルから１つのデータを読み込み，その値を返す。
     *
     *  @return 読み込んだ値
     *  @throw #ReadError
     */
    public double getNum() {
        try {
            for (;;) {
                int ttype = in.nextToken();
                if (ttype == in.TT_EOF) { // ファイル終端
                    close(); throw new ReadError();
                } else if (ttype == in.TT_NUMBER) { // 数値
                    return in.nval;
                } else if (ttype == '*') { // 欠損値
                    return Double.NaN;
                }
            }
        } catch (IOException e) { throw new ReadError(); }
    }
    /**
     *  データファイルからデータを読み込んだものを行列として返す。
     *
     *  @return 読み込んだ値
     *  @throw #ReadError
     */
    public double[][] readData() {
        double[][] m = new double[nCols][nRows];
        for (int i = 0; i < nRows; i++)
            for (int j = 0; j < nCols; j++)
                m[j][i] = getNum();
        close();
        return m;
    }
    /**
     *  データファイルからデータを読み込んだものを行列として返す。
     *
     *  @param  filename    データファイル名
     *  @return 読み込んだ値
     *  @throw #ReadError
     */
    public static double[][] readData(String filename) {
        return new StatData(filename).readData();
    }
}

