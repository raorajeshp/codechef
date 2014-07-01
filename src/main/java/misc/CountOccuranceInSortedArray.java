package misc;

/**
 * Created by rpradeshik on 6/29/14.
 */
public class CountOccuranceInSortedArray {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CountOccuranceInSortedArray.class);

    public void test(){
        dotest(new int[]{1, 1, 2, 2, 2, 2, 3}, 2, 4);
        dotest(new int[]{1, 1, 2, 2, 2, 2, 3}, 3, 1);
        dotest(new int[]{1, 1, 2, 2, 2, 2, 3}, 1, 2);
        dotest(new int[]{1, 1, 2, 2, 2, 2, 3}, 4, -1);
    }


    private void dotest(int[] array, int x, int answer){
    int count = count(array, x, array.length);
        log.info("count={} match={}", count, (answer == count) );
    }


    int count(int arr[], int x, int n)
    {
        int i; // index of first occurrence of x in arr[0..n-1]
        int j; // index of last occurrence of x in arr[0..n-1]

  /* get the index of first occurrence of x */
        i = first(arr, 0, n-1, x, n);

  /* If x doesn't exist in arr[] then return -1 */
        if(i == -1)
            return i;

  /* Else get the index of last occurrence of x. Note that we
      are only looking in the subarray after first occurrence */
        j = last(arr, i, n-1, x, n);

  /* return count */
        return j-i+1;
    }

    /* if x is present in arr[] then returns the index of FIRST occurrence
       of x in arr[0..n-1], otherwise returns -1 */
    int first(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            int mid = low + high >>> 1;  /*low + (high - low)/2;*/
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid -1), x, n);
        }
        return -1;
    }


    /* if x is present in arr[] then returns the index of LAST occurrence
       of x in arr[0..n-1], otherwise returns -1 */
    int last(int arr[], int low, int high, int x, int n)
    {
        if(high >= low)
        {
            int mid = low + high >>> 1;  /*low + (high - low)/2;*/
            if( ( mid == n-1 || x < arr[mid+1]) && arr[mid] == x )
                return mid;
            else if(x < arr[mid])
                return last(arr, low, (mid -1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }
}
