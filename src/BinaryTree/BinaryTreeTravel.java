package BinaryTree;

import java.util.Stack;

public class BinaryTreeTravel {
    //首先定义一颗二叉树的结点
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //采用递归方式遍历
    //前序遍历
    public static void preOredrRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOredrRecur(head.left);
        preOredrRecur(head.right);
    }
    //中序遍历
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
    //后序遍历
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    //非递归方式实现
    //前序遍历非递归方式实现，利用栈
    public static void preOrderUnRecur(Node head){
        System.out.print("pre-order: ");
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while(!stack.isEmpty()){//如果栈为空了，说明前面一轮已经没有东西压进去了
            head = stack.pop();
            System.out.print(head.value + " ");
            if(head.right != null){
                stack.add(head.right);
            }
            if(head.left != null){
                stack.add(head.left);
            }
        }
        System.out.println();
    }
    //中序遍历非递归实现
    public static void inOrderUnRecur(Node head){
        System.out.print("in-order: ");
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty()){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }
    //后序遍历的非递归实现
    public static void posOrderUnRecur(Node head){
        System.out.print("pos-order: ");
        if(head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();

            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right != null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }
        }
    }
}
