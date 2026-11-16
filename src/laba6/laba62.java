package laba6;
import java.util.Scanner;
public class laba62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long w = sc.nextLong();
        long h = sc.nextLong();
        //гран бин п
        long lo = 1;
        long hi = Math.max(w, h) * n;
        //бин п
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (fits(mid, n, w, h)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }
    static boolean fits(long m, long n, long w, long h) {
        long cols = m / w;//кол дип по ширине
        long rows = m / h;//кол дип по высоте
        if (cols == 0 || rows == 0) return false;
        long needed = (n + rows - 1) / rows; // ceil(n / rows), rows > 0
        return cols >= needed;
    }
}