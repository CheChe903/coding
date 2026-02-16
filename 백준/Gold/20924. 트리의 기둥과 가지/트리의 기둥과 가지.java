import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        if(N == 1) {
            System.out.println("0 0");
            return;
        }
        
        // 양방향 그래프로 저장
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(new int[]{b, d});
            graph.get(b).add(new int[]{a, d});
        }
        
        // 루트에서 트리 구성
        Map<Integer, TreeNode> nodes = new HashMap<>();
        boolean[] visited = new boolean[N + 1];
        
        TreeNode root = buildTree(R, -1, graph, nodes, visited);
        TreeNode gigaNode = root.getGigaNode();
        
        int pillarLength = root.getPillar();
        int branchLength = gigaNode.getMaxBranchLength();
        
        System.out.println(pillarLength + " " + branchLength);
    }
    
    static TreeNode buildTree(int cur, int parent, Map<Integer, List<int[]>> graph, 
                              Map<Integer, TreeNode> nodes, boolean[] visited) {
        visited[cur] = true;
        TreeNode node = new TreeNode(cur);
        nodes.put(cur, node);
        
        for(int[] edge : graph.get(cur)) {
            int next = edge[0];
            int weight = edge[1];
            
            if(next != parent && !visited[next]) {
                TreeNode child = buildTree(next, cur, graph, nodes, visited);
                node.addChild(child, weight);
            }
        }
        
        return node;
    }

    static class TreeNode {
        int value;
        Map<TreeNode, Integer> childs;

        public TreeNode(int value) {
            this.value = value;
            this.childs = new HashMap<>();
        }

        public void addChild(TreeNode node, int dirValue) {
            childs.put(node, dirValue);
        }

        public int getPillar() {
            int value = 0;  
            TreeNode tempRoot = this;
            while(tempRoot.childs.size() == 1) {
                for(TreeNode t : tempRoot.childs.keySet()) {
                    value += tempRoot.childs.get(t); 
                    tempRoot = t;
                }
            }
            return value; 
        }

        public TreeNode getGigaNode() {
            TreeNode tempRoot = this;
            while(tempRoot.childs.size() == 1) {
                for(TreeNode t : tempRoot.childs.keySet()) {
                    tempRoot = t;
                }
            }
            return tempRoot;
        }

        public int getMaxBranchLength() {
            if(childs.size() == 0) return 0;
            
            int maxLength = 0;
            
            for(TreeNode child : childs.keySet()) {
                int edgeWeight = childs.get(child);
                int childMaxDepth = child.getMaxDepth();
                maxLength = Math.max(maxLength, edgeWeight + childMaxDepth);
            }
            
            return maxLength;
        }

        public int getMaxDepth() {
            if(childs.size() == 0) return 0;
            
            int maxDepth = 0;
            for(TreeNode child : childs.keySet()) {
                int edgeWeight = childs.get(child);
                int childDepth = child.getMaxDepth();
                maxDepth = Math.max(maxDepth, edgeWeight + childDepth);
            }
            return maxDepth;
        }
    }
}