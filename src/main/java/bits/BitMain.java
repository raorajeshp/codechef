package bits;

import java.util.BitSet;

/**
 * Created by rpradeshik on 6/19/14.
 */
public class BitMain {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BitMain.class);

    public BitMain(){}
    public void test(){
//        countBits(143);
//        testOddEven(8);
//        testOddEven(9);
//        testOddEven(-9);
//
//        testIsSet(8, 2);
//        testIsSet(8, 3);
//
//        testToggle(43);
//
//        turnOffRightmost(5);
//
//        testIsNegative(9);
//        testIsNegative(-9);
//
//        log.info("flip 1={}", toBS( (~1) + 1 ) );
//        log.info("flip 1={}", toBS( -1 ) );
//
//        findRightmostPos(6);
//        findRightmostPos(2);
//        reverseBits(121);

//        testMid(0,6);
//        testMid(0,7);
//        testMid(6,0);

//    log.info("addInt={}", addInt(23, -27));
//        powerSet();
    }

    /**
     * Get the least number after deleting k digits from the input number.
     * For example, if the input
     * number is 24635, the least number is 23 after deleting 3 digits
     */

    void powerSet(){
        int A[] = {1,2,3,4,5};
        int N = 5;
        int Total = 1 << N;
        log.info("Total={}", Total);
        for ( int i = 0; i < Total; i++ ) {
            for ( int j = 0; j < N; j++) {
                if ( ((i >> j) & 1) > 0)
                    log.info("j={} arrayA[j]={}", j, A[j]);
            }
        }
    }

    int addInt(int a, int b){
        int limit = 0;
        while (b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
            if (++limit > 1000) break;
        }
        return a;
    }
    void testMid(int a, int b){
        log.info("  a={}, b={}, mid={}", a, b, (a +b >> 1) );
    }
    void countBits(int n){
        BitSet bs = BitSet.valueOf(new long[]{(long)n});
        log.info("source n={} 1 bits=" , Long.toBinaryString((long)n), bs.cardinality());

        int count = 0;

        while (n > 0){
            n = n & (n-1);
            if (++count > 100) break;
        }
        log.info("1 bits count = {}" , count);
    }

    void reverseBits(int n){
        log.info("Given num={}", toBS(n) );
        int result = 0;
        for (int i = 32; i > 0; i--)
        {
            result <<= 1;
            if ((n & 1) > 0)
                result |= 1;
            n >>= 1;
        }

        log.info("result={} bits={}", result, toBS( result) );
    }

    void reverseBits1(int num){
        log.info("Given num={}", toBS(num) );
        int count = 32 -1;
        int reverse_num = num;
        num >>= 1;
        while(num > 0)
        {
            reverse_num <<= 1;
            reverse_num |= num & 1;
            num >>= 1;
            count--;
        }
        reverse_num <<= count;
        log.info("reverse_num={} bits={}", reverse_num, toBS( reverse_num) );
    }

    void testOddEven(int n){
        String result =  ( (n & 1) > 0) ? "Odd":"Even";
        log.info("Given Number={} is={} ", n,  result );
    }

    void testIsSet(int n, int bitpos){
        boolean isSet = ( (n & (1 << bitpos)) > 0);
        log.info("Given Number={} For bitpos={} isSet={} bin={}", n, bitpos, isSet ,toBS(n) );
    }

    void testIsNegative(int n){
        boolean isNegative = ( (n & ~(1) + 1) > 0);
        log.info("Given Number={} isNegative={}", n, isNegative );
    }

    void findRightmostPos(int n){
        int rightPos = ( n & (-n) );
        log.info("Given Number={} rightPos={}", n, rightPos );
    }

    void turnOffRightmost(int n){
        int rightMost = n & (n - 1);
        log.info("Given Number={} Given bits={} rightMost={}", n, toBS(n), rightMost );
    }

    void testToggle(int n){
        int once = n ^ n;
        int twice = once ^ n;
        log.info("Given num={}, once={}, twice={}", n, once, twice);
    }

    String toBS(int n) {
        return Long.toBinaryString((long) n);
    }
}
