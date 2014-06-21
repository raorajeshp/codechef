package chef;

/**
 * Created by rpradeshik on 6/19/14.
 */
public class ChefMain {
    public static void main(String[] args){
//      System.out.println("From Java");
//      June19.easyTest();

//        print(" 123 is Palin=" + June19.isPalindrome(123) );
//        print(" 121 is Palin=" + June19.isPalindrome(121) );
//        print(" 10  is Palin=" + June19.isPalindrome(10) );
//        print(" 11  is Palin=" + June19.isPalindrome(11) );

        int[] numbers = { 15, 5, 12, 2, 100, 98, 101, 2, 1, 44};
        June21.quicksort(numbers);

    }


    private static void print(Object obj){
        System.out.println(obj);
    }
}
/* FORMAT **********************
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {


    }
}
*/