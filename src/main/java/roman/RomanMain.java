package roman;

import java.util.*;

/**
 * Created by rpradeshik on 6/28/14.
 */
public class RomanMain {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RomanMain.class);

    static final Map<Integer, String> numberMap = new LinkedHashMap<Integer, String>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };

    static final Map<String,Integer> symbolMap = new HashMap<String, Integer>() {
        {
            put("M",  1000);
            put("CM", 900);
            put("D",  500);
            put("CD", 400);
            put("C",  100);
            put("XC",  90);
            put("L",   50);
            put("XL",  40);
            put("X",   10);
            put("IX",   9);
            put("V",    5);
            put("IV",   4);
            put("I",    1);
        }
    };

    public void test() {
        for(int i = 0; i < 4054; i++){
            String roman = toRoman(i);
            int num = toInt(roman);
            log.info(" roman={}, num={} check={}", roman, num, (i == num) );
        }
    }

    public static String toRoman(int num) {
        int copyNum = num;
        String roman = "";

        for (int divider : numberMap.keySet()) {
            int div = num/divider;
            if (div > 0) for (int i = 0; i < div; i++) roman += numberMap.get(divider);
            //log.info(" div={} roman={} num={} divider={}", div, roman, num, divider);
            num = num - div * divider;
        }
        //log.info("for Given num={} roman={}", copyNum, roman);
        return roman;
    }

    public static int toInt(String roman) {
        int num = 0;
        char[] cArray = roman.toCharArray();

        for (int i = 0; i < cArray.length; i++){
            String first  = String.valueOf( cArray[i] );
            String second = i < cArray.length - 1? String.valueOf( cArray[i + 1] ) : "";

            if (symbolMap.containsKey(first+second)){
                num += symbolMap.get(first+second);
                if (!second.equals("")) i++;
            } else num += symbolMap.get(first);

        }
        //log.info("for Given roman={} num={}", roman, num);

        return num;
    }

    public static String toRomanOld(int num) {
        int copyNum = num;
        int limit = 0;
        final String[] divSymbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] divValue =     {1000, 900, 500, 400,   100, 90,   50,   40, 10,      9,   5,   4,   1};

        String roman = "";
        int arraypointer = 0;
        while (num > 0) {
            int div = num / divValue[arraypointer];
            if (div > 0) {
                for (int i = 0; i < div; i++) roman += divSymbol[arraypointer];
                log.info(" div={} roman={} num={}", div, roman, num);
            }
            num = num - (div * divValue[arraypointer]);
            arraypointer++;
            if ((limit++) > 200) break;//safety
        }

        log.info("for Given num={} roman={}", copyNum, roman);
        return roman;
    }

}