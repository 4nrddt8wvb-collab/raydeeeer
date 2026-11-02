package labasort32;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<BigInteger> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nums.add(new BigInteger(sc.next()));
        }

        Sorting<BigInteger> sorter = new RadixSort();
        sorter.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (BigInteger x : nums) {
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }
}