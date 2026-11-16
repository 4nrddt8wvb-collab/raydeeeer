package laba8;
import java.io.*;
import java.util.StringTokenizer;

public class laba82 {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String nStr = scanner.next();
        if (nStr == null) return;

        int n = Integer.parseInt(nStr);
        int size = 1;
        while (size < n) {
            size <<= 1;
        }

        int[] tree = new int[2 * size];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < 2 * size; i++) {
            tree[i] = INF;
        }

        for (int i = 0; i < n; i++) {
            tree[size + i] = scanner.nextInt();
        }

        for (int i = size - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }


        String kStr = scanner.next();
        if (kStr != null) {
            int k = Integer.parseInt(kStr);
            for (int q = 0; q < k; q++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();

                int left =  1 + size;
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
        }
        out.flush();
    }
}