package sort;


import java.util.Iterator;

/**
 * Created by rpradeshik on 6/28/14.
 */
public class LinkList {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LinkList.class);
    private LList mylist = null;

    public void test() {
        mylist = new LList();

        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);

        log.info("mylist={}", mylist);

        //test next
        //for(int i=1; i <= 5; i++ ) log.info("next={}", mylist.next());

        //
        testIterator();
        //testRecursiveReverse();
        //testReverse();
    }

    //java LinkedList
    private java.util.LinkedList<Integer> reverse(java.util.LinkedList<Integer> src){
        log.info("src={}", src);
        return src;
    }

    private void testIterator(){
        //test using iterator
        Iterator<Node> it = mylist.iterator();
        while(it.hasNext()) log.info("it node={}", it.next());
        //test original is still intact
        log.info("after iterator mylist={}", mylist);
    }

    private void testRecursiveReverse(){
        //test reverse using recursive
        mylist.reverse3();
        log.info("recursive mylist={}", mylist);
    }

    private void testReverse(){
        // worked
         mylist.reverse1();
         log.info("mylist={}", mylist);

        reverse(mylist);
        log.info("after reverse mylist={}", mylist);
    }

    // Reverse given LList for SingleLinked List
    private void reverse(LList srcList) {
        if (srcList == null) return;
        Node head = srcList.head;
        if (head == null || head.next == null) return;

        Node next = null, curr = head, prev = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        srcList.head = prev;
    }

    class LList {
        LList() {
        }

        class LIterator implements Iterator<Node>{
            Node pointer;
            LIterator(){
                pointer = head;
            }
            public Node next(){
                Node tmp = null;
                if (hasNext()){
                    tmp = pointer;
                    pointer = pointer.next;
                }

                return tmp;
            }
            public boolean hasNext(){
                return pointer != null;
            }
            public void remove(){

            }
        }

        Iterator<Node> iterator() {
            return new LIterator();
        }
        Node head;
        /* to add using ONLY head

                void add(int data){
                    if (head == null) {
                        head = new Node(data, null);
                    }
                    else {
                        Node np = head;
                        while(np.next != null) np = np.next;
                        np.next = new Node(data, null);
                    }
                }//end class

        */
        //using last pointer, to prevent using while loop
        Node last;

        void add(int data) {
            if (head == null) {
                head = new Node(data, null);
                last = head;
            } else {
                last.next = new Node(data, null);
                last = last.next;
            }

        }//end class

        void reverse3(){
            head = rrev(head);
        }

        private Node rrev(Node node){
            //if single
            if (node  == null || node.next == null) return node;
            log.debug("node value={}", node);
            Node secondNode = node.next;
            node.next = null;

            Node remainRev = rrev(secondNode);
            secondNode.next = node;
            return remainRev;
        }


        void reverse2() {
            //if empty of one element
            if (head == null || head.next == null) return;

            Node next = null;
            Node curr = head;
            Node prev = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            head = prev;
        }

        Node next() {
            Node tmp = null;

            if (head != null) {
                tmp = head;
                head = head.next;
                tmp.next = null;
            }

            return tmp;
        }

        void reverse1() {
            //empty or head return
            if (head == null || head.next == null) return;

            int loop = 0;
            Node nextNode = null;
            Node currNode = head;
            Node prevNode = null;

            while (currNode != null) {
                nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;

                if (++loop > 20) break;
            }
            log.debug("loop={}", loop);
            head = prevNode;

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node np = head;
            while (np.next != null) {
                sb.append(np.data).append(",");
                np = np.next;
            }
            sb.append(np.data);

            return sb.toString();
        }
    }

    class Node {
        int data;
        Node next;

        Node(int _data, Node _next) {
            data = _data;
            next = _next;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

}
