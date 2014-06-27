package card;

import java.util.*;

/**
 * Created by rpradeshik on 6/27/14.
 */
public class CardMain {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CardMain.class);
    public void test(){
        Deck deck = new Deck();
        //log.info("dec = {}", deck);
        List<AbstractCard> list = new ArrayList<>();
        //cards.addAll())
        for(AbstractSuite suite: deck.suiteArray){
            list.addAll(Arrays.asList(suite.cardArray));
        }

        log.info("size of list={}", list.size());
        log.info("list = {}", list);
        Collections.shuffle(list);
        log.info("after Shuffle list = {}", list);

        //Collections.sort(list, );
        Collections.sort(list,  new Comparator<AbstractCard>(){
            public int compare(AbstractCard here, AbstractCard that){
                int value = 0;
                if (here.hashCode() == that.hashCode()) value = 0;
                else if (here.hashCode() < that.hashCode()) value = -1;
                else value = 1;
                return value;
            }
        });

        log.info("after SORT list = {}", list);

    }

    class Card extends AbstractCard {
        public Card(String suite,String value){
            this.suite = suite;
            this.value = value;
        }
    }

    class Suite extends AbstractSuite{
        public Suite(String symbol){
            super(symbol);
        }
    }

    class Deck {
        final String[] SuiteNames = {"Diamond", "Hearts", "Spade", "Club"};
        final AbstractSuite[] suiteArray =  new Suite[SuiteNames.length];

        public Deck(){
            //init 4 suites
            for(int i = 0; i < SuiteNames.length; i++) suiteArray[i] = new Suite(SuiteNames[i]);
        }

        @Override public String toString(){
            StringBuilder sb = new StringBuilder();
            for(AbstractSuite s: suiteArray) sb.append(s.toString());
            return "\n [ " + sb.toString() + "]";
        }
    }

    protected class AbstractSuite{
        final String[] ValueArray = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        final AbstractCard[] cardArray = new AbstractCard[ValueArray.length];
        String suite;
        protected AbstractSuite(String symbol){
            this.suite = symbol;
            for(int i = 0; i < ValueArray.length; i++) cardArray[i] = new Card(this.suite, ValueArray[i]);
        }

        @Override public String toString(){
            StringBuilder sb = new StringBuilder();
            for(AbstractCard c: cardArray) sb.append(c.toString()).append(",");
            return "\n { " + sb.toString() + "}";
        }
    }

    protected class AbstractCard /*implements Comparable<Card>*/{
        String suite;
        String value;


        @Override public int hashCode(){
            final int prime = 31;
            int result = 1;
            result = result * prime + suite.hashCode();
            result = result * prime + value.hashCode();
            return result;
        }

        @Override public boolean equals(Object obj){
            if (obj == null) return false;
            if (obj == this) return true;
            if (obj.getClass() != this.getClass()) return false;

            Card other = (Card) obj;
            if (other.suite != this.suite)  return false;
            if (other.value != this.value)  return false;
            return true;
        }
        /*
        public int compareTo(Card other){
            int value = 0;
            if (this.hashCode() == other.hashCode()) value = 0;
            else if (this.hashCode() < other.hashCode()) value = -1;
            else value = 1;
            return value;
        }*/

        @Override public String toString(){
            return suite + "-" + value ;
        }
    }

}
