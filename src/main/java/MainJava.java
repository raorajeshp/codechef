import bits.BitMain;
import bst.BinaryTreeMain;
import card.CardMain;
import card.CardDeck;
import cbook.Ch1;
import hashtable.Hashtable1;
import misc.CountOccuranceInSortedArray;
import misc.MidPointInArray;
import roman.RomanMain;
import sort.LinkList;
import sort.QuickSort;

/**
 * Created by rpradeshik on 6/27/14.
 */
public class MainJava {
    public static void main(String[] args){
        // http://ashayraut.files.wordpress.com/2014/05/interview-preparation-best-100-ashay-raut.pdf

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

        BinaryTreeMain bstMain = new BinaryTreeMain();
                bstMain.test();

        MidPointInArray midPointInArray = new MidPointInArray();
        //midPointInArray.findBalanceIndex();

        CountOccuranceInSortedArray countOccuranceInSortedArray = new CountOccuranceInSortedArray();
        //countOccuranceInSortedArray.test();

        Hashtable1 hashtable1 = new Hashtable1();
        //hashtable1.test();

        LinkList linkList = new LinkList();
        //linkList.test();

        ATest aTest = new ATest();
        //aTest.test();

        Ch1 ch1 = new Ch1();
        //ch1.test();
    }
}

/*
git config --global user.name "raorajeshp"
git config --global user.email "rao.rajeshp@gmail.com"
git config --global credential.helper cache

git config user.name "raorajeshp"
git config user.email "rao.rajeshp@gmail.com"
git config credential.helper cache
*/