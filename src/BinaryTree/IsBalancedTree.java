package BinaryTree;

public class IsBalancedTree {
    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    //用到递归思想，需要返回我需要的数据，所以要自定义一个返回类型
    public static class ReturnType{
        public int height;
        public boolean isBalanced;

        public ReturnType(boolean isBalanced,int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(Node head){
        return process(head).isBalanced;
    }

    public static ReturnType process(Node x){
        if(x == null){
            return new ReturnType(true,0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int height = Math.max(leftData.height,rightData.height);
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && (Math.abs(leftData.height - rightData.height) < 2);
        return new ReturnType(isBalanced,height);
    }

}
