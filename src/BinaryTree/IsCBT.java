package BinaryTree;

import java.util.LinkedList;

public class IsCBT {
    //首先定义一个二叉树的结点
    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }
        //这里利用队列的先进先出，就可以宽度一次遍历二叉树中的结点了
        LinkedList<Node> queue = new LinkedList<>();
        //取出的结点依次判断这个结点是否是叶结点以及左右孩子，所以设置以下变量
        boolean leaf = true;
        Node l = null;
        Node r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            //依次从队列中取出结点，并且观察孩子以及是否叶子结点
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((l == null && r != null)
                ||
                (leaf && (l != null || r != null))//这里结合下面的leaf来看
            ){
                return false;
            }
            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(r == null && l == null){
                leaf = true;
            }

        }

        return true;
    }

}
