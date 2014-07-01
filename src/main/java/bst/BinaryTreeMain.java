package bst;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rpradeshik on 6/28/14.
 */
public class BinaryTreeMain {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BinaryTreeMain.class);

    public void test() {
        // testHash();
        //        test3OrderTraversals(); //this does insert too
        // testMinMax();
        // testSize();

        //testDelete();
        //testDupeDelete();

        // DO NOT USE REMOVE, it has BUG
        //testRemove();
        //testRemoveDupe();

        //testSearch();
        //        testDupeSearch();

        //testDupesCount();

        //testClone();
        //testIsBst();
        //testDups();

        //testRevOrder();

        //testGetLeast(24635);

        testHeightWidthDia();
    }

    public void testGetLeast(int n){
        BinaryTree bTree = new BinaryTree();
        for (int a : String.valueOf(n).toCharArray()) bTree.insert(a - 48);

        bTree.printInsertOrder();
/*

        bTree.printInOrder();
        log.info("inOrder Tree=\n {}", bTree.inOrderData);

        bTree.printPreOrder();
        log.info("preOrder Tree=\n {}", bTree.preOrderData);

        bTree.printPostOrder();
        log.info("postOrder Tree=\n {}", bTree.postOrderData);
*/

    }

    public void testHeightWidthDia(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        log.info("height={} width={} diameter={}", bTree.height(), bTree.width(), bTree.diameter());
    }

    public void testRevOrder(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        bTree.printInOrder();
        log.info("inOrder Tree=\n {}", bTree.inOrderData);

        bTree.printRevOrder();
        log.info("revOrder Tree=\n {}", bTree.revOrderData);
    }

    public void testDupesCount(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = //{40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};
                {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93, 30, 10, 30}; //30 and 10 are made dupes
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        bTree.printDupes();
    }

    public void testSearch(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        Node found = bTree.search(25);
        log.info("25 found={}", (found != null));

        found = bTree.search(99);
        log.info("99 found={}", (found != null));
    }

    public void testDupeSearch(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 32, 50, 78, 93};//look for 32
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        Node found = bTree.search(32);
        log.info("theSize={}  found={} found-right={} found-left={}", bTree.size(), (found != null), found.right.value, found.left.value);

        bTree.printInOrder();
        log.info("inOrder Tree=\n {}", bTree.inOrderData);

        bTree.printPreOrder();
        log.info("preOrder Tree=\n {}", bTree.preOrderData);

        bTree.printPostOrder();
        log.info("postOrder Tree=\n {}", bTree.postOrderData);
    }

    public void testRemove(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        bTree.printInOrder();
        log.info("sortedTree=\n {}", bTree.inOrderData);

        boolean removed = bTree.remove(bTree.root, 25);
        bTree.printInOrder();
        log.info("removed={}, sortedTree=\n {}", removed, bTree.inOrderData);
    }

    public void testRemoveDupe(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData =
                //{40, 10, 3, 32, 17, 30, 25, 38, 50, 32, 78, 93}; //32 node dupe
        {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93, 50}; //50 leaf dupe

        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        bTree.printInOrder();
        log.info("sortedTree=\n {}", bTree.inOrderData);

        boolean removed = bTree.remove(bTree.root, 50);
        bTree.printInOrder();
        log.info("removed={}, sortedTree=\n {}", removed, bTree.inOrderData);
    }

    public void testDelete(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        bTree.printInOrder();
        log.info("sortedTree=\n {}", bTree.inOrderData);

        bTree.delete(25);
        bTree.printInOrder();
        log.info("sortedTree=\n {}", bTree.inOrderData);
    }

    public void testDupeDelete(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData =
          //{40, 10, 3, 32, 17, 30, 25, 38, 50, 32, 78, 93}; //32 node dupe
        {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93, 50}; //50 leaf dupe

        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        bTree.printInOrder();
        log.info("sortedTree=\n {}", bTree.inOrderData);

        bTree.delete(50);
        bTree.printInOrder();
        log.info("sortedTree=\n {}", bTree.inOrderData);
    }

    public void testDups(){
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};
        final int[] nodeDupeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 32, 78, 93}; //32 node dupe
        final int[] leafDupeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93, 50}; //50 leaf dupe

        printDupe(treeData, "NODupe");
        printDupe(nodeDupeData, "nodeDupeData");
        printDupe(leafDupeData, "leafDupeData");
    }

    private void printDupe(int[] treeData, String testType){
        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        bTree.printInOrder();
        log.info("testType={} sortedTree=\n {}", testType, bTree.inOrderData);
    }

    public void testIsBst() {
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};

        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);

        log.info("FIRST IsBst={}", bTree.isBST(bTree.root));
        // /*
        //we do InOrder so that it indexes ascending
        bTree.printInOrder();
        log.info("indexStore={} size={}", bTree.indexStore, bTree.indexStore.size());

        //interchange 5 and 8 index (exchange 32 and 50 value positions)
        Node node32 = bTree.indexStore.get(5);
        Node node50 = bTree.indexStore.get(8);
        node32.value = 50;
        node50.value = 32;
        log.info("After Interchange indexStore={}", bTree.indexStore);

        log.info("SECOND IsBst={}", bTree.isBST(bTree.root));

        // */

    }



    public void testSize() {
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};

        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        log.info("bTree size={} matches Array size={}", bTree.size(), (treeData.length == bTree.size()));
    }


    public void testClone() {
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};

        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);

        bTree.printInOrder();
        log.info("bTree Match InOrder={}", bTree.inOrderData);

        BinaryTree bTreeClone = this.clone(bTree);
        bTreeClone.printInOrder();
        log.info("bTreeClone Match InOrder={}", bTreeClone.inOrderData);
        log.info("CLONE does MAtch={}", (Arrays.hashCode(bTree.inOrderData.toArray()) == Arrays.hashCode(bTreeClone.inOrderData.toArray())));

    }

    public void testMinMax() {
        // http://cdn.javabeat.net/wp-content/uploads/2013/11/BST_Example.jpg
        final int[] treeData = {40, 10, 3, 32, 17, 30, 25, 38, 50, 78, 93};

        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);

        log.info("Min={} Match={}", bTree.findMin(), bTree.findMin() == 3);
        log.info("Max={} Match={}", bTree.findMax(), bTree.findMax() == 93);
    }

    public void test3OrderTraversals() {
        final int[] treeData = {40, 25, 78, 10, 3, 17, 32, 30, 38, 50, 93};

        final int[] inOrderData = {3, 10, 17, 25, 30, 32, 38, 40, 50, 78, 93};
        final int[] preOrderData = {40, 25, 10, 3, 17, 32, 30, 38, 78, 50, 93};
        final int[] postOrderData = {3, 17, 10, 30, 38, 32, 25, 50, 93, 78, 40};

        BinaryTree bTree = new BinaryTree();
        for (int a : treeData) bTree.insert(a);
        boolean match = false;

        log.info("Min={} Match={}", bTree.findMin(), bTree.findMin() == 3);
        log.info("Max={} Match={}", bTree.findMax(), bTree.findMax() == 93);

        bTree.printInOrder();
        match = (Arrays.hashCode(inOrderData) == Arrays.hashCode(bTree.inOrderData.toArray()));
        log.info("Match  InOrder={} output=\n{}", match, bTree.inOrderData );

        bTree.printPreOrder();
        match = (Arrays.hashCode(preOrderData) == Arrays.hashCode(bTree.preOrderData.toArray()));
        log.info("Match PreOrder={} output=\n{}", match, bTree.preOrderData);

        bTree.printPostOrder();
        match = (Arrays.hashCode(postOrderData) == Arrays.hashCode(bTree.postOrderData.toArray()));
        log.info("Match PostOrder={} output=\n{}", match, bTree.postOrderData);

    }

    private int[] toArray(List<Integer> intList) {
        int[] iArray = new int[intList.size()];
        int i = 0;
        for (int a : intList) iArray[i++] = a;

        return iArray;
    }

    private BinaryTree clone(BinaryTree srcBst) {
        BinaryTree twin = null;
        if (srcBst == null) return null;
        twin = new BinaryTree(cloneHelper(srcBst.root));
        return twin;
    }

    private Node cloneHelper(Node node) {
        if (node == null) return null;
        else return new Node(node.value, cloneHelper(node.left), cloneHelper(node.right));
    }

    private void testHash(){
        log.info("Aa".hashCode() + "," + "BB".hashCode());
        log.info("Ba".hashCode() + "," + "CB".hashCode());
        log.info("Ca".hashCode() + "," + "DB".hashCode());
        log.info("Da".hashCode() + "," + "EB".hashCode());

    }
}

