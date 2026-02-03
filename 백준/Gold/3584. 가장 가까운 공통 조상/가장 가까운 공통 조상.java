import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            Map<Integer, TreeNode> nodeMap = new HashMap<>();

            for(int j =0; j<N-1; j++) {
                st= new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                TreeNode currentNode;
                if(nodeMap.containsKey(A)) {
                    currentNode = nodeMap.get(A);
                } else {
                    currentNode = new TreeNode(A, null, new ArrayList<>());
                    nodeMap.put(A, currentNode);
                }
                if(nodeMap.containsKey(B)) {
                    currentNode.addChild(nodeMap.get(B));
                    nodeMap.get(B).parent = currentNode;
                } else {
                    TreeNode newNode = new TreeNode(B, currentNode,new ArrayList<>());
                    currentNode.addChild(newNode);
                    nodeMap.put(B, newNode);
                }
            }
            st = new StringTokenizer(br.readLine());
            TreeNode first = nodeMap.get(Integer.parseInt(st.nextToken()));
            TreeNode second = nodeMap.get(Integer.parseInt(st.nextToken()));
        
            Set<Integer> firstParent = new HashSet<>();
            

            while(first != null) {
                firstParent.add(first.value);
                first = first.parent;
            }
            while(second != null) {
                if(firstParent.contains(second.value)) {
                    sb.append(second.value).append("\n");
                    break;
                }
                second = second.parent;
            }
            
        }
        System.out.println(sb);
    }

    public static class TreeNode {
        int value;
        TreeNode parent;
        List<TreeNode> childs;

        public TreeNode(int value, TreeNode parent, List<TreeNode> childs) {
            this.value = value;
            this.parent = parent;
            this.childs = childs;
        }

        public void addChild(TreeNode t) {
            childs.add(t);
        }
    }
}