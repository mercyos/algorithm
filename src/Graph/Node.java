package Graph;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;//这里是指这个点发散出去的连接的Node
    public ArrayList<Edge> edges;//这里指这个点发散出去即出度所代表的的Edge

    public Node(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }
}
