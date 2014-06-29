package newcard;

import java.util.*;

/**
 * Created by rpradeshik on 6/28/14.
 */
public class CardDeck {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CardDeck.class);

    public void test(){
        Deck deck = new Deck();

        log.info("Before Shuffle deck={} ", deck);
        deck.shuffle();
        log.info("AFTER  Shuffle deck={} ", deck);
        deck.arrange();
        log.info("after  ARRANGE deck={} ", deck);
    }
}

class Deck {
    Suite[] suits;
    List<Card> allCards = new ArrayList<>();
    public Deck() {
        suits = new Suite[SuiteEnum.values().length];
        Suite tmpSuite = null;
        for (SuiteEnum sEnum : SuiteEnum.values()) {
            tmpSuite = new Suite(sEnum);
            suits[sEnum.ordinal()] = tmpSuite;
            allCards.addAll( Arrays.asList(tmpSuite.cards));
        }
    }

    public void shuffle(){
        Collections.shuffle(allCards);
    }

    public void arrange(){
        //use comparator now
        Collections.sort(allCards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                int cmpValue= 0;
                int c1Value = o1.suite.value + o1.card.value;
                int c2Value = o2.suite.value + o2.card.value;
                if (c1Value < c2Value)  cmpValue= -1;
                else if (c1Value > c2Value)  cmpValue= 1;

                return cmpValue;
            }
        });
    }
    @Override
    public String toString() {
        return "{ DECK Cards=" + allCards + "}";
    }
}

class Suite {
    private Suite() {
    }

    SuiteEnum suite;
    Card[] cards;

    public Suite(SuiteEnum suite) {
        this();
        this.suite = suite;
        this.cards = new Card[CardSet.values().length];
        for (CardSet cEnum : CardSet.values())
            cards[cEnum.ordinal()] = new Card(suite, cEnum);
    }

    @Override
    public String toString() {
        return "\n [ SUITE: " + suite.name + " Cards=" + Arrays.toString(cards) +  " ]";
    }
}

class Card {
    SuiteEnum suite;
    CardSet card;

    public Card(SuiteEnum suite, CardSet card) {
        this.suite = suite;
        this.card = card;
    }

    @Override
    public String toString() {
        return suite.name + "-" + card.name;
    }
}

enum CardSet {
    C_2("2", 2),
    C_3("3", 3),
    C_4("4", 4),
    C_5("5", 5),
    C_6("6", 6),
    C_7("7", 7),
    C_8("8", 8),
    C_9("9", 9),
    C_10("10", 10),
    C_J("J", 11),
    C_Q("Q", 12),
    C_K("K", 13),
    C_A("A", 14);

    String name;
    int value;

    private CardSet(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

enum SuiteEnum {
    Suite_Diamond("Diamonds", 1000),
    Suite_Heart("Hearts", 2000),
    Suite_Spade("Spade", 3000),
    Suite_Club("Club", 4000);

    String name;
    int value;

    private SuiteEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
