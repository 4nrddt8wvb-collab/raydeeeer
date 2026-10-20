package labasort2;

import java.util.*;

interface Sort<T extends Comparable<T>> {
    void sort(List<T> nums);
}

class MergeSort implements Sort<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            slice(nums, start, middle);
            slice(nums, middle + 1, end);
            merge(nums, start, middle, end);
        }
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> left = new ArrayList<>(nums.subList(start, middle + 1));
        List<Integer> right = new ArrayList<>(nums.subList(middle + 1, end + 1));

        int i = 0, j = 0, k = start;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                nums.set(k++, left.get(i++));
            } else {
                nums.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) nums.set(k++, left.get(i++));
        while (j < right.size()) nums.set(k++, right.get(j++));
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        new MergeSort().sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(nums.get(i));
        }
        System.out.println(sb);
    }
}