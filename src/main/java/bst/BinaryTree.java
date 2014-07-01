package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rpradeshik on 6/28/14.
 */
public class BinaryTree {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BinaryTree.class);

    public List<Integer> inOrderData = new ArrayList<Integer>();
    public List<Integer> revOrderData = new ArrayList<Integer>();
    public List<Integer> preOrderData = new ArrayList<Integer>();
    public List<Integer> postOrderData = new ArrayList<Integer>();
    public List<Node> indexStore = new ArrayList<Node>();

    public Node root;

    private int size = 0;
    private int index = 0;

    public int size() {
        return this.size;
    }

    public BinaryTree() {
    }

    public BinaryTree(Node node) {
        this.root = node;
    }

    public void insert(int value) {
        root = insertRec(root, value);
        size++;
    }

    /*
    Node prev = null;
    public void insert(int value) {
        root = insertRec(root, value);
        if (prev == null ) prev = root;
        else {
            prev.next = root.left == null ? root.right : root.left;
            log.info("prev.next={}", prev.next);
            prev = prev.next;
        }
        size++;
    }
    */
    //http://shashank7s.blogspot.com/2011/03/write-program-to-remove-duplicates-from.html
    private Node insertRec(Node node, int value) {
        if (node == null) return new Node(value);
        if (value <= node.value) node.left = insertRec(node.left, value);
        else node.right = insertRec(node.right, value);

        return node;
    }

    public void printInsertOrder(){
        //log.info("nextNode={}", root.next);

        Node nextNode = root;
        int limit = 0;
        while(nextNode.next != null) {
            log.info("nextNode={}", nextNode.value);
            if (++limit > 20) break;
        }

    }
    public Node search(int value) {
        return search(root, value);
    }

    private Node search(Node node, int value) {
        if (node == null)
            return null;
        else if (value == node.value)
            return node;
        else if (value < node.value)
            return search(node.left, value);
        else
            return search(node.right, value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) throw new RuntimeException("given value=" + value + " not found to delete.");

        if (value < node.value)
            node.left = delete(node.left, value);
        else if (value > node.value)
            node.right = delete(node.right, value);
        else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            else {
                // get data from the rightmost node in the left subtree
                node.value = retrieveData(node.left);
                // delete the rightmost node in the left subtree
                node.left = delete(node.left, node.value);
            }
        }
        return node;
    }

    private int retrieveData(Node node) {
        while (node.right != null) node = node.right;
        return node.value;
    }

    public void printDupes() {
        //we will do inOrderTraversel
        printDupesRec(this.root, new Store());
    }

    private void printDupesRec(Node node, Store store){
        if (node == null) return;
        printDupesRec(node.left, store);
        int currValue = node.value;
        if (store.prevStore != currValue){
            if (store.dupeCount > 0)
                log.info("Number={} duplicated={}", store.prevStore, store.dupeCount);
            store.prevStore = currValue; store.dupeCount=0;
        }
        else store.dupeCount++;
        printDupesRec(node.right, store);
    }

    class Store{
        int prevStore= Integer.MIN_VALUE;
        int dupeCount = 0;
    }

    // DO NOT USE REMOVE, it has BUG
    boolean remove(Node node, int value) {
        if (node == null)
            return false;
        if (remove(node.left, node.value))
            node.left = node.left.left;
        if (node.value == value)
            return true;
        if (remove(node.right, value))
            node.right = node.right.left;
        return false;
    }

    public int findMin() {
        if (root == null) return 0;

        Node current = root;
        while (current.left != null) current = current.left;
        return current.value;
    }

    public int findMax() {
        if (root == null) return 0;

        Node current = root;
        while (current.right != null) current = current.right;
        return current.value;
    }

    /**
     * first value is the ROOT
     * then prints left sides nodes first, starting from node value first
     * then left node, then right node
     * <p/>
     * This is best for Serialize and un-serialize
     */

    public void printPreOrder() {
        log.info("=== printPreOrder ==");
        preOrderData.clear();
        printPreOrderRec(root);
    }

    private void printPreOrderRec(Node current) {
        if (current == null) return;
        //log.info(String.valueOf(current.value));
        preOrderData.add(current.value);
        printPreOrderRec(current.left);
        printPreOrderRec(current.right);
    }

    /**
     * this is used to print values in ascending order,
     * starts from bottom left most to the right
     */
    public void printInOrder() {
        log.info("=== printInOrder ==");
        inOrderData.clear();

        printInOrderRec(root);
    }

    private void printInOrderRec(Node current) {
        if (current == null) return;
        printInOrderRec(current.left);
        //log.info(String.valueOf(current.value));
        inOrderData.add(current.value);
        indexStore.add(current);
        printInOrderRec(current.right);
    }

    /**
     * this is used to print values in ascending order,
     * starts from bottom left most to the right
     */
    public void printRevOrder() {
        log.info("=== printInOrder ==");
        indexStore.clear();

        printRevOrderRec(root);
    }

    private void printRevOrderRec(Node current) {
        if (current == null) return;
        printRevOrderRec(current.right);
        //log.info(String.valueOf(current.value));
        revOrderData.add(current.value);
        indexStore.add(current);
        printRevOrderRec(current.left);
    }

    public void printPostOrder() {
        if (root == null) return;
        log.info("=== printPostOrder ===");
        postOrderData.clear();
        printPostOrderRec(root);
    }

    private void printPostOrderRec(Node current) {
        if (current == null) return;
        printPostOrderRec(current.left);
        printPostOrderRec(current.right);
        //log.info(String.valueOf(current.value));
        postOrderData.add(current.value);
    }

    public boolean isBST(Node node){
        return isBST(node, null);
    }

    private boolean isBST(Node node, Node prev){
        //log.info("isBST");
        if (node != null) {
            if (!isBST(node.left, prev)) return false;

            if (prev != null && node.value <= prev.value) return false;
            prev = node;

            return isBST(node.right, prev);
        }
        return true;
    }
    /**
     * We need height to be calculated first to calculate width and diameter of tree
     * @return
     */
    public int height(){
        return height(root);
    }

    private int height(Node node){
        if (node == null) return -1;
        else return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Diameter of a tree is max of height and diameter of node
     */
    public int diameter(){
        return diameter(root);
    }

    private int diameter(Node node){
        if (node == null) return 0;
        int hh = height(node.left) + height(node.right) + 3;
        int dd = Math.max(diameter(node.left), diameter(node.right));

        return Math.max(hh, dd);
    }

    /**
     * Width of the tree is max number of nodes on a level of tree
     */
    public int width(){
        int max = 0;
        int depth = height();
        for(int k=0; k < depth; k++){
            int temp = width(root, k);
            if (temp > max) max = temp;
        }

        return max;
    }

    private int width(Node node, int depth){
        if (depth == 0) return 1;
        else if (node == null) return 0;
        else return width(node.left, depth - 1) + width(node.right, depth - 1);
    }
}
