package misc;

/**
 * Created by rpradeshik on 6/29/14.
 */
public class MidPointInArray {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MidPointInArray.class);

    public void findBalanceIndex() {
        int a[]= {1,3,4,6,7,2,5,9,1,
                  11,9,6,5,8,9,1}, i=0, j=0, sum_l=0, sum_r=0;

        j = a.length - 1;
        while(i<j) {
            //printf("Indice Values: %d -- %d\n", a[i], a[j]);
            if(sum_l < sum_r)
                sum_l += a[i++];
            else sum_r += a[j--];
           // log.info("Indices: {} -- {}", i, j);
        }
        log.info("SUMs:{} -- {}", sum_l, sum_r);
        if(sum_l == sum_r) log.info("Finally The balance is {}", i);
        else log.info("-Final---No balance can be found----");
    }
}
