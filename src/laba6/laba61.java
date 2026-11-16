package laba6;
import java.io.*;
import java.util.*;
public class laba61 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        int n = (int) st.nval;//кол-во эл n
        int[] arr = new int[n];// соз массив(0)
        for (int i = 0; i < n; i++) {
            st.nextToken();
            arr[i] = (int) st.nval;//остс мас
        }
        //чтение массива с запр
        st.nextToken();
        int m = (int) st.nval;

        StringBuilder sb = new StringBuilder();//изменяемая строка для накопления массивы
        //обр запросов
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int q = (int) st.nval;
            int best = findClosest(arr, q);
            if (i > 0) sb.append(' ');
            sb.append(best);
        }
        System.out.println(sb.toString());
    }
    //бинарный поиск
    static int findClosest(int[] arr, int q) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;//сдвиг на 1 бит(деление на 2 с отбр др ч), без риска перепеолнения
            if (arr[mid] < q) lo = mid + 1;
            else hi = mid;
        }
        int best = arr[lo];
        if (lo > 0) {
            int left = arr[lo - 1];
            if (Math.abs(left - q) <= Math.abs(best - q)) {
                best = left;
            }
        }
        return best;
    }
}