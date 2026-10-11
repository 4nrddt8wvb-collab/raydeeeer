import java.util.Arrays;

public class laba12 {
    public int removeElementInplace(String[] arr, String val){
        int k=0;

        for(int i=0; i < arr.length; i++){
            if (arr[i]!= null && !arr[i].equals(val)){
                arr[k]=arr[i];
                k++;
            }
        }
        for (int i = k; i < arr.length; i++){
            arr[i] = "_";
        }
        return k;
    }
    public static void main(String[] args) {
        laba12 m = new laba12();

        String[] arr1 = {"4", "5", "5", "4"};
        int len1 = m.removeElementInplace(arr1, "4");
        System.out.println("len=" + len1);
        System.out.println(Arrays.toString(arr1));

        String[] arr2 = {"0", "2", "6", "6", "1", "0", "4", "6"};
        int len2 = m.removeElementInplace(arr2, "6");
        System.out.println("len=" + len2);
        System.out.println(Arrays.toString(arr2));

    }
}