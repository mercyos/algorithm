package List;

import java.util.Stack;

public class IsPalindromeList {
    //定义结点
    public class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(head);
            cur = cur.next;
        }

        while(head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

//    public static boolean isPalindrome3(Node head){
//        //使用快慢指针来解决
//        if(head == null || head.next == null){
//            return false;
//        }
//        Node slow = head;
//        Node fast = head;
//
//        while(slow.next != null && fast.next.next != null){//寻找mid
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        fast = slow.next;//fast成为了有部分的第一个结点
//        slow.next = null;//左边部分与右边部分断开链接
//        Node n3 = null;
//        while(fast != null){//右边部分翻转
//            fast.next;
//        }
//    }
}
