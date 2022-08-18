package List;

public class FindFirestIntersectNode {
    //定义一个链表结点
    public class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if(loop1 == null && loop2 == null){//都无环的情况
            return noLoop(head1,head2);
        }
        if(loop1 != null && loop2 != null){
            return bothLooop(head1,head2,loop1,loop2);
        }
        return null;
    }

    //查看链表是否有环，视频中有环返回入环结点,无环返回null
    public static Node getLoopNode(Node head){
        if(head == null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;

        while(n1 != n2){
            if(n1.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }

        n2 = head;
        //走到这里了说明相等了，有环了
        while(n2 != n1){
            n2 = n2.next;
            n2 = n1.next;
        }
        return n1;
    }

    //都无环的情况
    public static Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int lengthHead1 = 0;
        int lengthHead2 = 0;

        while(cur1.next != null){
            lengthHead1++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            lengthHead2++;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = (lengthHead1 - lengthHead2) > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;

        int betweenLength = Math.abs(lengthHead1 - lengthHead2);
        while(betweenLength != 0){
            betweenLength--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLooop(Node head1,Node head2,Node loop1,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
