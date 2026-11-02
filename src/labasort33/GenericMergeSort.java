package labasort33;

// GenericMergeSort.java
import java.util.ArrayList;
import java.util.List;

public class GenericMergeSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(List<T> nums) {
        if (nums == null || nums.size() <= 1) return;
        mergeSort(nums, 0, nums.size() - 1);
    }

    private void mergeSort(List<T> nums, int start, int end) {
        if (start >= end) return;
        int middle = start + (end - start) / 2;
        mergeSort(nums, start, middle);
        mergeSort(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(List<T> nums, int start, int middle, int end) {
        List<T> left = new ArrayList<>(nums.subList(start, middle + 1));
        List<T> right = new ArrayList<>(nums.subList(middle + 1, end + 1));

        int i = 0, j = 0, k = start;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                nums.set(k++, left.get(i++));
            } else {
                nums.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) nums.set(k++, left.get(i++));
        while (j < right.size()) nums.set(k++, right.get(j++));
    }
}