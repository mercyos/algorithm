package BinaryTree;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.LinkedList;

//验证是否是二叉搜索树
public class IsBST {
    //首先定义二叉树结点
    public class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isBST(Node head){
        if(head == null){
            return true;
        }
        LinkedList<Node> inOrderList = new LinkedList<>();
        process(head,inOrderList);
        int pre = Integer.MIN_VALUE;
        for(Node cur : inOrderList){
            if(pre >= cur.value){
                return false;
            }
            pre = cur.value;
        }

        return true;
    }

    public static void process(Node node,LinkedList<Node> inOrderList){
        if(node == null){
            return;
        }
        process(node.left,inOrderList);
        inOrderList.add(node);
        process(node.right,inOrderList);
    }

}
