package chef;

import java.util.Scanner;

/**
 * Created by rpradeshik on 6/19/14.
 */
public class June21 {
    // http://www.codechef.com/problems/TEST
    public static void easyTest(){
        Scanner in = new Scanner(System.in);
        int input = -1;
        while( (input = in.nextInt()) != 42) System.out.println(input);
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
}
