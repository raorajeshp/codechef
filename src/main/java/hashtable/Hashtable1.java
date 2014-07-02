package hashtable;

/**
 * Created by rpradeshik on 6/29/14.
 */
public class Hashtable1 {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Hashtable1.class);
    byte[] b0 = new byte[100];
    byte[] b1 = new byte[100];
    byte[] b2 = new byte[100];
    byte[] b3 = new byte[100];
    byte[] b4 = new byte[100];

    private void store(int num, int value){
        byte rem = 0; byte vrem = 0;

        rem = (byte) (num % 100);   num = num / 100;
        vrem =(byte) (value % 100); value = value / 100;
        b0[rem] = vrem;

        rem = (byte) (num % 100);   num = num / 100;
        vrem =(byte) (value % 100); value = value / 100;
        b1[rem] = vrem;

        rem = (byte) (num % 100);   num = num / 100;
        vrem =(byte) (value % 100); value = value / 100;
        b2[rem] = vrem;

        rem = (byte) (num % 100);   num = num / 100;
        vrem =(byte) (value % 100); value = value / 100;
        b3[rem] = vrem;

        rem = (byte) (num % 100);   num = num / 100;
        vrem =(byte) (value % 100); value = value / 100;
        b4[rem] = vrem;

    }

    private int find(int num){
        int found = 1;
        short rem = 0;
        rem = (byte) (num % 100);   num = num / 100;
        found += b0[rem];

        rem = (byte) (num % 100);   num = num / 100;
        found += b1[rem] * 100;

        rem = (byte) (num % 100);   num = num / 100;
        found += b2[rem] * 100 * 100;

        rem = (byte) (num % 100);   num = num / 100;
        found += b3[rem] * 100 * 100 * 100;

        rem = (byte) (num % 100);   num = num / 100;
        found += b4[rem] * 100 * 100 * 100 * 100;

        return found;
    }

    public void test(){
        int start = Integer.MAX_VALUE - 1000;
        store(start, start);
        log.info("ShortMaxtry={} start={} found={}", ((start >> 16) & 0xFF), start, find(start));

    }
}
