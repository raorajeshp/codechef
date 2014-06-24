package chef;

/**
 * Created by rpradeshik on 6/19/14.
 * <p/>
 * BST implementation in which insertion and deletion are accomplished by
 * recursive algorithms (insertion after Carrano, deletion after Weiss).
 * <p/>
 * Data Structure (class) BST --- binary search tree
 * public member functions:
 * constructor --- for the tree itself
 * clear       --- empty out the tree
 * walk        --- traverse the data structure, showing the values
 * in increasing order.
 * pretty      --- Display the tree structure (level-order traversal)
 * insert      --- insert one cell into the data structure
 * find        --- find, based on data value; returns pointer to cell
 * delete      --- remove one cell from the data structure
 * avgDepth    --- average depth of all tree nodes
 * height      --- height of the entire tree
 * size        --- number of nodes in the tree
 */
public class BSTMain {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BSTMain.class);

    public BSTMain() {
    }

    public void testBits() {
    }

    static boolean UNIQUE = false;

    static class BSTnode {
        int util;

        Comparable data;
        int height;
        int size;
        BSTnode left;
        BSTnode right;

        //constructor for leaf
        BSTnode(Comparable data) {
            this.data = data;
            this.height = 0;
            this.size = 1;
            this.left = null;
            this.right = null;
        }
    }//BSTnode

    BSTnode root;
    BSTnode free;
    int nItems = 0;

    //properties
    public int size() {
        return (root == null ? 0 : root.size);
    }

    public int height() {
        return (root == null ? -1 : root.height);
    }

    private int sumDepths(BSTnode node, int deep) {
        if (node == null) return 0;
        else return deep +
                sumDepths(node.left, deep + 1) +
                sumDepths(node.right, deep + 1);
    }

    public double avgDepth() {
        if (root == null) return -1;
        else return sumDepths(root, 0) / root.size;
    }

    //FIND
    public Comparable find(Comparable value) {
        BSTnode current = root;

        while (current != null && !current.data.equals(value))
            current = value.compareTo(current.data) < 0 ? current.left : current.right;

        return current == null ? null : current.data;
    }

    //EMPTY out whole tree
    public void clear() {
        autumn(root);
        root = null;
    }

    //INSERT new node
    public void insert(Comparable value) {
        root = insert(root, value);
    }

    private BSTnode insert(BSTnode node, Comparable value) {

        //root case
        if (node == null) node = build(value);
        else if (value.compareTo(node.data) < 0)
            node.left = insert(node.left, value);
        else if (value.compareTo(node.data) > 0)
            node.right = insert(node.right, value);
        else if (!UNIQUE)
            node.right = insert(node.right, value);
        else System.err.println (value + " is already in.");

        //reset size and height
        node.size = newSize(node);
        node.height = newHt(node);

        return null;
    }

    // PRIVATE METHODS ///////////////////
    private static int newHt(BSTnode node){
        if (node.left == null && node.right == null)
            return 0; //leaf node the height is zero
        else if (node.left == null) return 1 + node.right.height;
        else if (node.right == null) return 1 + node.left.height;
        else return 1 + Math.max(node.left.height, node.right.height);
    }

    private static int newSize(BSTnode node){
        if (node.left == null && node.right == null)
            return 1; //leaf node the size is 1, onely
        else if (node.left == null) return 1 + node.right.size;
        else if (node.right == null) return 1 + node.left.size;
        else return 1 + node.left.size +  node.right.size;
    }

    private BSTnode build(Comparable data) {
        BSTnode rtn = null;

        if(free == null) rtn = new BSTnode(data);
        else {
            rtn = free;
            free = free.right;

            rtn.data = data;
            rtn.size = 1;
            rtn.height = 0;
            rtn.left = null;
            rtn.right = null;
        }

        return rtn;
    }

    private void autumn(BSTnode node) {
        if (node != null) {
            autumn(node.left);
            autumn(node.right);

            recycle(node);
        }
    }

    //push node into free, used by delete or insert,th leaf
    private void recycle(BSTnode node) {
        node.left = null;
        node.right = free;
        free = node;
    }


}
