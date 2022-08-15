package List;

import java.util.Comparator;

public class HashAndTree {
    //定义一个链表的Node
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //写一个Node的比较器，Node是通过value的大小来比较的
    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2){
            return o1.value - o2.value;
        }
    }


}
