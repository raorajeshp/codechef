package chef;

import java.util.*;
import java.util.BitSet;
/**
 * Created by rpradeshik on 6/19/14.
 */
public class June19 {
    // http://www.codechef.com/problems/TEST
    public static void easyTest(){
        java.util.Scanner in = new java.util.Scanner(System.in);
        int input = -1;
        while( (input = in.nextInt()) != 42) System.out.println(input);
    }
    public static boolean isPalindrome(Integer input){
        if (input < 10) return false;
        int palin = input;
        int rev = 0;

        int count = 0;
        while (palin != 0 && count < 100){
            int remainder = palin % 10;
            rev = rev * 10 + remainder;
            palin = palin / 10;
            count++;
        }
        //print("reversed = " + rev);
        return (rev == input);
    }

    public static boolean isPalindrome1(Integer input){
        boolean isPal = false;

        for(int i = 0; i < 1; i++){
            print( Integer.bitCount(input) );
            print(Integer.rotateRight(input, 8));
            /*
            print( Integer.toBinaryString(input) );
            print( Integer.toBinaryString(Integer.reverse(input)) );
            print( Integer.toBinaryString(Integer.reverseBytes(input)) );
            print( Integer.toHexString(input));
            */
        }

        return isPal;
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
