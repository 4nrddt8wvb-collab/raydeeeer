package labasort31;

import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums){
        int[] count = new int[128];

        for(int x : nums){
            count[x]++;
        }
        int idx = 0;
        for (int value = 0; value < count.length; value++){
            for(int k = 0; k < count[value]; k++){
                nums.set(idx++,value);
            }
        }
    }
}
