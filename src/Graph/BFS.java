package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        HashSet<Node> map = new HashSet<Node>();
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(node);
        map.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value);
            for(Node next : cur.nexts){
                if(!map.contains(next)){
                    map.add(next);
                    queue.add(next);
                }
            }
        }


    }

}
