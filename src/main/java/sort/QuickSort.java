package sort;

import java.util.Arrays;

/**
 * Created by rpradeshik on 6/28/14.
 */
public class QuickSort {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QuickSort.class);

    public void test(){

    }

    public void quicksort(int[] numbers){
        log.info("before Sorting numbers= {}", Arrays.toString(numbers));
        qsort(numbers, 0, numbers.length - 1);
        log.info("AFTER  Sorting numbers= {}", Arrays.toString(numbers));
    }

    private static void qsort(int[] nums, int low, int high){
        int i = low, j = high, pivot = nums[low+high >>> 1];

        while(i <= j){
            while(nums[i]< pivot) i++;
            while(nums[j]> pivot) j--;

            if (i<=j){
                int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
                i++; j--;
            }
        }

        if (low < j) qsort(nums, low, j);
        if (i < high) qsort(nums, i, high);
    }

}
