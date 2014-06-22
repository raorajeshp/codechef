package chef;

import java.util.BitSet;

/**
 * Created by rpradeshik on 6/19/14.
 */
public class June21 {
    public static void testBitSet(){
        BitSet bs = new BitSet(12);
        print(bs.size());

        bs.set(1, true);
        bs.set(10, true);
        printbs(bs);
        //BitSet.valueOf(new long[0]);


    }

    public static void countBits(int n){
        BitSet bs = BitSet.valueOf(new long[]{(long)n});
        print("1 bits=" + bs.cardinality());

        int count = 0;

        while (n > 0){
            n = n & (n-1);
        count++; if (count > 100) break;
        }
        print("1 bits count =" + count);


    }

    public static void quicksort(int[] numbers){
        print("before Sorting");
        print(numbers);
        qsort(numbers, 0, numbers.length - 1);
        print("after Sorting");
        print(numbers);
    }

    private static void qsort(int[] numbers, int low, int high){
        int i = low, j = high, pivot = numbers[low + (high-low)/2];

        while(i <= j){
            while(numbers[i] < pivot) i++;
            while(numbers[j] > pivot) j--;

            if(i <= j){
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;

                i++;
                j--;
            }
        }
        //recursive again
        if ( low < j  )qsort(numbers, low, j);
        if ( i < high )qsort(numbers, i, high);
    }

    private static void print(Object obj){
        System.out.println(obj);
    }

    private static void print(int[] array){
        String comma = "{";
        for(int a:array) {
            System.out.print(comma);
            System.out.print(a);
            comma = ",";
        }
        System.out.println("}");
    }

    private static void printbs(BitSet bs){
        print("len=" + bs.toLongArray().length);
        print(Long.toBinaryString(bs.toLongArray()[0]) );
    }

    private static void printbs(int i){

        print(Long.toBinaryString((long)i) );
    }
}
