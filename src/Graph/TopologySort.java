package Graph;

import java.util.*;

public class TopologySort {
    public static List sortTopology(Graph graph){
        HashMap<Node,Integer> inMap = new HashMap<Node, Integer>();
        Queue<Node> zeroInQueue = new LinkedList<Node>();

        for(Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<Node>();
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        HashMap<Integer,String> test = new HashMap<>();
        test.put(1,"tom");
        test.put(2,"jack");
        test.put(3,"jason");

        System.out.print(test.values());
    }
}
