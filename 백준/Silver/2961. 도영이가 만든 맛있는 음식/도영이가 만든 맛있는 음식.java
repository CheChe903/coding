import java.io.*;
import java.util.*;

class Node {
    private int S;
    private int E;

    
    Node(int S, int E) {
        this.S = S;
        this.E = E;
    }

    public int getS() {
        return S;
    }

    public int getE() {
        return E;
    }
}

public class Main {
    static List<Node> nodes;
    static int answer;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        StringTokenizer st;
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            nodes.add(node);
        }
        visited = new boolean[nodes.size()];
        answer = Integer.MAX_VALUE;
        dfs(0, 0, new ArrayList<>());
        

        System.out.println(answer);
    }

    static void dfs(int currentIndex, int depth, List<Node> currentNodes) {
        
        if(depth > 0) {
            int currentS = 1;
            int currentE = 0;
            for(int i = 0; i<currentNodes.size(); i++) {
                currentS *= currentNodes.get(i).getS();
                currentE += currentNodes.get(i).getE();
            }
            answer = Math.min(answer, Math.abs(currentS - currentE));
        }



        for(int i = currentIndex; i<nodes.size(); i++) {
            if(visited[i]== false) {
                currentNodes.add(nodes.get(i));
                visited[i] =true;
                dfs(i+1, depth+1, currentNodes);
                currentNodes.remove(currentNodes.size()-1);
                visited[i] = false;
            }
        }

    }
}  