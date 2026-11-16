package laba6;
import java.util.Scanner;
public class laba63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double lo = 1.0;
        double hi = Math.max(2.0, Math.sqrt(a) + 1.0);

        for (int i = 0; i < 200; i++) {//число итерация
            double mid = (lo + hi) / 2.0;
            double val = mid * mid - mid + Math.sqrt(mid);
            if (val < a) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        double x = (lo + hi) / 2.0;
        System.out.printf("%.10f%n", x);
    }
}