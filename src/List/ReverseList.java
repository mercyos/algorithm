package List;

import java.util.Stack;

public class ReverseList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public static Node reverseList(Node head){
        Node next = null;
        Node pre = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;

            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node headRes = ReverseList.reverseList(head1);
        printLinkedList(headRes);

    }
}
