package laba8;
import java.io.*;
import java.util.StringTokenizer;

public class laba82 {
    public static void main(String[] args) throws IOException {
        // Максимально быстрый ввод/вывод для таких задач
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // Инициализация размера дерева (степень двойки >= n)
        int size = 1;
        while (size < n) {
            size <<= 1;
        }

        // Дерево отрезков
        int[] tree = new int[2 * size];
        int INF = Integer.MAX_VALUE;

        // Заполняем дерево "бесконечностями" (чтобы не мешали при поиске минимума)
        for (int i = 0; i < 2 * size; i++) {
            tree[i] = INF;
        }

        // Читаем массив
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[size + i] = Integer.parseInt(st.nextToken());
        }

        // Строим дерево снизу вверх
        for (int i = size - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }

        // Читаем количество запросов
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        // Обрабатываем запросы
        for (int q = 0; q < k; q++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            // Границы для итеративного поиска (0-базовая индексация)
            int left = l + size;
            int right = r + 1 + size; // r+1, так как полуинтервал [l, r]

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

        out.flush(); // Обязательно сбрасываем буфер вывода в конце
    }
}