/**
 *  1/f雑音
 *
 *  @version $Revision: 1.3 $, $Date: 2003/04/28 23:23:18 $
 */

import java.util.Random;

public class PinkNoise {
    static final int N = 8192;
    public static void main(String[] args) {
        double x[] = new double[N];
        double y[] = new double[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            x[i] = r.nextGaussian();
        FFT fftN = new FFT(N);
        fftN.fft(x, y);
        x[0] = y[0] = 0;
        for (int i = 1; i < N/2; i++) {
            double scale = 1.0 / Math.sqrt(i);
            x[i] *= scale;  x[N-i] *= scale;
            y[i] *= scale;  y[N-i] *= scale;
        }
        x[N/2] /= N/2;
        y[N/2] /= N/2;
        fftN.ifft(x, y);
        for (int i = 0; i < N; i++)
            System.out.println((float)x[i]);
    }
}
