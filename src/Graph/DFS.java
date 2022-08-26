package Graph;

import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static void dfs(Node node){
        if(node == null){
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> set = new HashSet<Node>();
        stack.push(node);
        set.add(node);
        System.out.print(node.value);

        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                stack.push(cur);
                stack.push(next);
                set.add(next);
                System.out.print(next.value);
                break;
            }
        }
    }

}
