package hashtable;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by rpradeshik on 7/2/14.
 */
public class TreeMapExample {
    /**
     * 
     */
    //value and index
    TreeMap<Integer, Integer> treeMap = null;

    public TreeMapExample(){
        treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int ret = 0;
                if (o1 < o2) ret = 1;
                else if (o1 > o2) ret = -1;

                return ret;
            }
        });

    }
    public void test(int num){
        int limit = 100;

        while(num > 0){


        }
    }
}
