package cbook;

import java.util.Arrays;

/**
 * Created by rpradeshik on 7/20/14.
 */
public class Ch1 {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Ch1.class);

    public void test() {
        //1.1//        test_hasUniqueChars();
        //1.2//        test_reverse();
        //1.3//        test_permuteString();
        //1.4        test_replaceSpace();
        //1.5
        test_stringCompress();
    }

    void test_hasUniqueChars() {
        log.info("abc={}", hasUniqueChars("abcd") == true);
        log.info("abb={}", hasUniqueChars("abbd") == false);
    }

    //1.1
    private boolean hasUniqueChars(String src) {
        //time = O(n) space = O(256)
        boolean unique = true;
        char[] srcArray = src.toCharArray();
        int[] array256 = new int[256]; //assuming ascii chars, instead unicode

        for (int i = 0, len = srcArray.length; i < len && unique; i++) {
            if (array256[srcArray[i]] > 0) unique = false;
            else array256[srcArray[i]] = 1;
        }

        log.debug("srcArray={}", Arrays.toString(srcArray));
        return unique;
    }

    private boolean hasUniqueChars_1(String src) {
        boolean unique = true;
        char[] srcArray = src.toCharArray();
        int len = srcArray.length;

        for (int i = 0; i < len && unique; i++) {
            for (int j = i + 1; j < len && unique; j++) {
                if (srcArray[i] == srcArray[j]) unique = false;
            }
        }
        return unique;
    }

    void test_reverse() {
        log.info("abc={}", reverse("abc").equals("cba"));
        log.info("abcd={}", reverse("abcd").equals("dcba"));
    }

    //1.2
    private String reverse(String src) {
        //time = O(n/2) space = O(1)
        char[] srcArray = src.toCharArray();

        for (int i = 0, len = srcArray.length; i < len / 2; i++) {
            char tmp = srcArray[i];
            srcArray[i] = srcArray[len - i - 1];
            srcArray[len - i - 1] = tmp;
        }

        return String.valueOf(srcArray);
    }

    void test_permuteString() {
        log.info("abcd, cabd={}", isPermuteString("abcd", "cabd") == true);
        log.info("defg, efgh={}", isPermuteString("defg", "efgh") == false);
    }

    //1.3
    private boolean isPermuteString(String s1, String s2) {
        //time=O(n) space = O(256)
        boolean isPermute = true;
        int[] array256 = new int[256];//assuming given chars are ascii, not unicode!

        if (s1 == null || s2 == null) isPermute = false;
        else if (s1.length() != s2.length()) isPermute = false;
        else {
            for (char s1Char : s1.toCharArray()) ++array256[s1Char];
            //log.debug("array256={}", array256);
            for (char s2Char : s2.toCharArray()) {
                if (--array256[s2Char] < 0) {
                    isPermute = false;
                    break;
                }
            }
        }
        return isPermute;
    }

    private void test_replaceSpace() {
        //[Mr Rajesh Rao] 13 , 4 extra spaces
        log.debug("Mr Rajesh Rao=[{}]", replaceSpace("Mr Rajesh Rao    ", 13));
        //[Mr Rajesh Rao] 12 , 4 extra spaces
    }

    //1.4
    private String replaceSpace(String src, int length) {
        String replaced = null;
        int countSpaces = 0;
        char[] str = src.toCharArray();
        for (int i = 0; i < length; i++)
            if (str[i] == ' ') countSpaces++;

        int newLength = length + (countSpaces * 2);
        //str[newLength] = '\0';
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';

                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }

        replaced = new String(str);

        return replaced;
    }

    //1.5
    private void test_stringCompress() {
        log.info("abcd, cabd={}", stringCompress("aabcccccaaa") == "a2b1c5a3");
        log.info("defg, efgh={}", stringCompress("abbcd") == "abbcd"); //, "a1b2c1d1"
    }

    private String stringCompress(String src) {
        String compString = "";
        if (src == null || src.length() == 1) return src;

        char[] srcArray = src.toCharArray();
        char prevChar = srcArray[0];
        int prevCount = 1;

        for(int i = 1; i < srcArray.length; i++){
            if (srcArray[i] !=  prevChar) {
                compString += prevChar + "" + (prevCount);
                prevChar = srcArray[i];
                prevCount = 1;
            } else prevCount++;

        }
        compString += prevChar + "" + (prevCount);

        log.debug("compString={}", compString);

        return compString;
    }
}
