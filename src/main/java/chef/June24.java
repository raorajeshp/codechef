package chef;

import java.util.*;

/**
 * Created by rpradeshik on 6/19/14.
 */
public class June24 {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(June24.class);

    public June24() {
    }

    public void test() {
//        printMid(0,6);
//        printMid(0,7);
//        printMid(6,0);


    }

    public void testBST(){
            Integer[] a = {1,5,2,7,4};
            BST<Integer> bst = new BST<Integer>();
            for(Integer n : a) bst.insert(n);

            bst.preOrderTraversal();
            System.out.println();

            //testing comparator
            //build a mirror BST with a rule:  Left > Parent > Right
            //code for the comparator at the bottom of the file
            bst = new BST<Integer>(new MyComp1());
            for(Integer n : a) bst.insert(n);

            bst.preOrderTraversal();
            System.out.println();
            bst.inOrderTraversal();
            System.out.println();


            for(Integer n : bst) System.out.print(n);
            System.out.println();

            System.out.println(bst);

            //testing restoring a tree from two given traversals
            bst.restore(new Integer[] {11,8,6,4,7,10,19,43,31,29,37,49},
                    new Integer[] {4,6,7,8,10,11,19,29,31,37,43,49});
            bst.preOrderTraversal();
            System.out.println();
            bst.inOrderTraversal();
            System.out.println();

            //testing diameter
            System.out.println("diameter = " + bst.diameter());
            //testing width
            System.out.println("width = " + bst.width());

    }

    void printMid(int a, int b){
        log.info("  a={}, b={}, mid={}", a, b, (a +b >> 1) );
    }

    void fillRandoms(){
        Arrays.hashCode(new Object[0]);
        Random random = new Random();
        Set<Integer> cards = new HashSet<>(52);
        for(int i = 0; i < 13*4; i++){
            int ranInt = random.nextInt(52);
            log.info("i={} random={} contains={}", i, ranInt, cards.contains(ranInt));
            cards.add(ranInt);
        }
        Arrays.toString(new Object[0]);
        log.info("total size={}", cards.size());
    }

    class Node{
        Node left;
        Node right;
        int value;

        Node(Node left, Node right, int value){
            this.left = left;
            this.right = right;
            this.value = value;
        }

        Node findNode(Node root, int value){
            if (root == null) return null;
            int currentValue = root.value;

            if (currentValue == value) return root;
            if (value < currentValue) return findNode(root.left, value);
            else return findNode(root.right, value);
        }
    }

}