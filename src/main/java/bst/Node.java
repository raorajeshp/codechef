package bst;

/**
 * Created by rpradeshik on 6/28/14.
 */
public class Node {
    public int  value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override public String toString(){
        return String.valueOf(value);
    }
}
