package chef;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by rpradeshik on 6/29/14.
 */
public class Hashtable {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Hashtable.class);
    byte[] b0 = new byte[256];
    byte[] b1 = new byte[256];
    byte[] b2 = new byte[256];
    byte[] b3 = new byte[256];

    private void store(int num, int value){
        b0[(num >>> 24) & 0xFF] = (byte)( (value >> 24) & 0xFF );
        b1[(num >>> 16) & 0xFF] = (byte)( (value >> 16) & 0xFF );
        b2[(num >>>  8) & 0xFF] = (byte)( (value >>  8) & 0xFF );
        b3[(num >>>  0) & 0xFF] = (byte)( (value >>  0) & 0xFF );
    }

    private int find(int num){
        int found = -1;
        log.info("find b0={}", ( (byte) b0[(num >> 24) & 0xFF] ) );
        log.info("find b1={}", ( (byte) b1[(num >> 16) & 0xFF] ) );
        log.info("find b2={}", ( (byte) b2[(num >>  8) & 0xFF] ) );
        log.info("find b3={}", ( (byte) b3[(num >>  0) & 0xFF] ) );


        found =
                (  ( ( (byte) b0[(num >> 24) & 0xFF] )<< 24 )& 0xFF )|
                (  ( ( (byte) b1[(num >> 16) & 0xFF] )<< 16 )& 0xFF )|
                (  ( ( (byte) b2[(num >>  8) & 0xFF] )<<  8 )& 0xFF )|
                (  ( ( (byte) b3[(num >>  0) & 0xFF] )<<  0 )& 0xFF );


        return found;
    }

    public void test(){
/*
        int start = Integer.MAX_VALUE - 1000;
        store(start, start);
        log.info("try={} start={} found={}", ((start >> 16) & 0xFF), start, find(start));
*/
        ArrayList<Integer> list = null;
        Set<Integer> set   = null;

        list.indexOf(1);

        Integer.decode("asdf");
    }

    public void testOLD() {
        int value = 1234;
        short[] shortArray = new short[2];
/*
byte b = (byte)0x96;
int n = 0xFF & b; // Again 0..255
 */
        /*
        result[0] = (byte)(value >> 24) & 0xfF;
        result[1] = (value >> 16) & 0xFF;
        result[2] = (value >> 8) & 0xFF;
        result[3] = value & 0xFF;*/

//        log.info("result array={}", Arrays.toString(result));
//        for (int r : result) log.info("bits = {}", Long.toBinaryString((long) r));
        //log.info("Int max={} byteMax={}", (Integer.MAX_VALUE / Byte.MAX_VALUE * 2 ), Byte.MAX_VALUE);
        //log.info("pow={} Int Max={} 2^31={}", (long)Math.pow(256,3), Integer.MAX_VALUE, (long) Math.pow(2, 31));
        //int intMax = Integer.MAX_VALUE;

        //log.info("aByte FF={} byteToString={}", (toBS((byte)0b11111111)) , (Byte.toString((byte)0b11111111)));

        byte b = (byte)0xff;
        //int n = 0xFF & b; // Again 0..255
        log.info("aByte FF={} Int.toBinString={}", (0xFF & b) , Integer.toBinaryString(0xFF & b) );
        String binString = Integer.toBinaryString(Integer.MAX_VALUE - 1);
        log.info("ToBinString={} len={}", binString, binString.length());
        String fullInt =
"1111111111111111111111111111110";
String left = "1111111111111101" ;
String right= "111111111111110";

        log.info("parse left={} right={} full={}",
                Integer.parseInt(left, 2), Integer.parseInt(right, 2) , Integer.parseInt(left + right, 2));
int mainInt = Integer.parseInt(left + right, 2);
        log.info("right bit={} left ={}",
                ( (mainInt >> 16) & 0xFFFF ) , ( (mainInt >> 0) & 0xFFFF )    );

        short[] leftArray = new short[0xFFFF];
        short[] rightArray = new short[0xFFFF];
        log.info("size={}", leftArray.length);
        //leftArray[(mainInt >> 16) & 0xFFFF] =
    }

private static String toBS(byte aByte){
    return Long.toBinaryString(aByte);
}
}
