package knownAlgorithms;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = { 9, 3, 7, 6, 2, 5, 4 };
        for (int n : nums) {
            System.out.print(n);
        }
        System.out.println(" ");
        InsertionSort.sort(nums);

        for (int n : nums)
            System.out.print(n);
    }

    public static void sort(int[] arr) {
        int k, i, j;
        for (i = 1; i < arr.length; i++) {
            k = arr[i];
            for (j = i - 1; j >= 0; --j) {
                if (k < arr[j])
                    arr[j + 1] = arr[j];
                else
                    break;
            }
            arr[j + 1] = k;
        }
    }
}
