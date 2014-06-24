package chef;

/**
 * Created by rpradeshik on 6/19/14.
 */
public class June22 {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(June22.class);

    public June22(){}
    public void testBits(){
//        testOddEven(8);
//        testOddEven(9);
//        testOddEven(-9);

//        testIsSet(8, 2);
//        testIsSet(8, 3);

//        testToggle(43);

//        turnOffRightmost(5);

//        testIsNegative(9);
//        testIsNegative(-9);
//
//        log.info("flip 1={}", toBS( (~1) + 1 ) );
//        log.info("flip 1={}", toBS( -1 ) );

//        findRightmostPos(6);
//        findRightmostPos(2);

        reverseBits(121);
    }

    /*
    for (i = sizeof(int) * 8; i; --i)
{
result <<= 1;
if (n & 1)
result |= 1;
n >>= 1;
}
return result;
}
     */
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
