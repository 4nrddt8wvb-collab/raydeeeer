package labasort31;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        new CountingSort().sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(nums.get(i));
        }
        System.out.print(sb);
    }
}
