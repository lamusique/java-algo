// Matrix1.java -- Java での行列の例 1
// $Revision: 1.4 $, $Date: 2003/04/28 23:23:17 $

class Matrix1 {
    static void matprint(double[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length-1; j++)
                System.out.print(x[i][j] + "\t");
            System.out.println(x[i][x[i].length-1]);
        }
    }
    public static void main(String[] args) {
        double[][] a = new double[2][3];
        a[1][2] = 4;
        matprint(a);
        double[][] b = {{11,12,13,14},{21,22,23,24},{31,32,33,34}};
        matprint(b);
    }
}
