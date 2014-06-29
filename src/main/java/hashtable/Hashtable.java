package hashtable;

import java.util.Arrays;

/**
 * Created by rpradeshik on 6/29/14.
 */
public class Hashtable {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Hashtable.class);

    public void test() {
        int value = 1234;
        int[] result = new int[4];
        result[0] = (value >> 24) & 0xFF;
        result[1] = (value >> 16) & 0xFF;
        result[2] = (value >> 8) & 0xFF;
        result[3] = value & 0xFF;

        log.info("result array={}", Arrays.toString(result));
        for (int r : result) log.info("bits = {}", Long.toBinaryString((long) r));
    }
}
