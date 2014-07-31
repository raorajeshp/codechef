/**
 * Created by rpradeshik on 7/2/14.
 */
import java.util.*;

public class ATest {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ATest.class);

    public void test(){

        //see if string gets trimmed for null char
        String test = "Some Long  String   Last";
        char[] cArray = test.toCharArray();
        char prevChar = cArray[0];
        for(int i = 1; i < cArray.length; i++) {
            if (cArray[i] == ' ' && prevChar == ' ') {
//                prevChar = cArray[i] ;
                cArray[i] = '\0';
            }
            else prevChar = cArray[i] ;
            }
        log.debug("beforeClean={} afterClean={}", test, String.valueOf(cArray));
        }

}
