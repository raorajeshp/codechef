import bits.BitMain;
import bst.BstMain;
import card.CardMain;
import card.CardDeck;
import roman.RomanMain;
import sort.QuickSort;

/**
 * Created by rpradeshik on 6/27/14.
 */
public class MainJava {
    public static void main(String[] args){
        int[] numbers = { 15, 5, 12, 2, 100, 98, 101, 2, 1, 44};
        QuickSort quickSort = new QuickSort();
        //sortMain.quicksort(numbers);

        BitMain bitMain = new BitMain();
        //bitMain.test();

        CardMain cardMain = new CardMain();
        //cardMain.test();

        CardDeck cardDeck = new CardDeck();
        //cardDeck.test();

        RomanMain romanMain =   new RomanMain();
        //romanMain.test();

        BstMain bstMain = new BstMain();
        bstMain.test();
    }
}
