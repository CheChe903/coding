import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        private int value;
        private Node parent;
        private List<Node> children = new ArrayList<>();

        public Node(int value) { this.value = value; }
        public int getValue() { return value; }
        public Node getParent() { return parent; }
        public List<Node> getChildren() { return children; }
        public void setParent(Node parent) { this.parent = parent; }
        public void addChild(Node child) { children.add(child); }
    }

    static List<Integer>[] adj;
    static Node[] nodes;
    static int[] size;
    static int N, R, Q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());


        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        nodes = new Node[N + 1];
        size = new int[N+1];
        for (int i = 1; i <= N; i++) nodes[i] = new Node(i);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        buildTree(R, 0);
        countSubtreeNodes(R);

        for(int i= 0; i<Q; i++) {
            int input = Integer.parseInt(br.readLine());

            System.out.println(size[input]);
        }
    }

    static void buildTree(int cur, int parent) {
        for (int nxt : adj[cur]) {
            if (nxt == parent) continue;
            nodes[nxt].setParent(nodes[cur]);
            nodes[cur].addChild(nodes[nxt]);
            buildTree(nxt, cur);
        }
    }

    static void countSubtreeNodes(int cur) {
        size[cur] = 1;
        for(Node node :  nodes[cur].children) {
            countSubtreeNodes(node.value);
            size[cur] += size[node.value];
        }
    }
}
