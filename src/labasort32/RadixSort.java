package labasort32;

import java.math.BigInteger;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        if (nums == null || nums.size() <= 1) return;

        int n = nums.size();
        BigInteger[] arr = nums.toArray(new BigInteger[0]);
        BigInteger[] buffer = new BigInteger[n];

        BigInteger ten = BigInteger.TEN;

        for (int pos = 0; pos < 20; pos++) {
            BigInteger divisor = ten.pow(pos);

            int[] count = new int[10];
            int[] digits = new int[n];

            for (int i = 0; i < n; i++) {
                digits[i] = arr[i].divide(divisor).mod(ten).intValue();
                count[digits[i]]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }


            for (int i = n - 1; i >= 0; i--) {
                int d = digits[i];
                count[d]--;
                buffer[count[d]] = arr[i];
            }


            BigInteger[] tmp = arr;
            arr = buffer;
            buffer = tmp;
        }


        for (int i = 0; i < n; i++) {
            nums.set(i, arr[i]);
        }
    }
}