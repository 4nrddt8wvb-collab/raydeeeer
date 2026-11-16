package laba8;
import java.io.*;
import java.util.StringTokenizer;

public class laba82 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        //инициализация размера дерева (степень двойки >= n)
        int size = 1;
        while (size < n) {
            size <<= 1;
        }

        //дерево отрезков
        int[] tree = new int[2 * size];
        int INF = Integer.MAX_VALUE;

        //заполняем дерево(чтобы не мешали при поиске минимума)
        for (int i = 0; i < 2 * size; i++) {
            tree[i] = INF;
        }

        //чит массив
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[size + i] = Integer.parseInt(st.nextToken());
        }

        //строим дерево снизу вверх
        for (int i = size - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        //чит кол запр
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        //обрабатыв запр
        for (int q = 0; q < k; q++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            //границы для поиска
            int left = l + size;
            int right = r + 1 + size;

            int min = INF;

            while (left < right) {
                if ((left & 1) == 1) {
                    min = Math.min(min, tree[left]);
                    left++;
                }
                if ((right & 1) == 1) {
                    right--;
                    min = Math.min(min, tree[right]);
                }
                left >>= 1;
                right >>= 1;
            }

            out.println(min);
        }

        out.flush();
    }
}