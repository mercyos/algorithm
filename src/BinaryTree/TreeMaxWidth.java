package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;

public class TreeMaxWidth {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static int getMaxWidth(Node head){
        if(head == null){
            return 0;
        }
        int maxWidth = 0;
        int curWidth = 0;
        int curLevel = 0;
        HashMap<Node,Integer> levelMap = new HashMap<>();
        levelMap.put(head,1);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Node node = null;
        Node left = null;
        Node right = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            left = node.left;
            right = node.right;

            if(left != null){
                levelMap.put(left,levelMap.get(node) + 1);
            }
            if(right != null){
                levelMap.put(right,levelMap.get(node) + 1);
            }
            if(levelMap.get(node) > curLevel){
                curWidth = 0;
                curLevel = levelMap.get(node);
            }else{
                curWidth++;
            }
            maxWidth = Math.max(maxWidth,curWidth);
        }
        return maxWidth;

    }

}
