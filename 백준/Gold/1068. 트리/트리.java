import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] A;
    static int answer;
    static boolean visited[];
    static int deleteNode;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new ArrayList[N];

        for(int i =0; i<N; i++) {
            A[i]= new ArrayList<>();
        }
        
        int root =-1;
        int check[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            check[i]= cur;
        }

        deleteNode = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++) {
            int cur = check[i];

            if(deleteNode == cur || i == deleteNode)
                continue;
            if(cur >=0)
                A[cur].add(i);
            else if(cur ==-1)
                root = i;
        }

        visited = new boolean[N];
        answer =0;
        if(root==-1) {
            System.out.println(0);
            return;
        }
        bfs(root);

        System.out.println(answer);
   }

   static void bfs(int node) {


        Queue<Integer> queue  = new LinkedList<>();

        queue.add(node);
        visited[node] = true;


        while(!queue.isEmpty()) {

            int nowNode = queue.poll();

            if(nowNode == deleteNode) {
                visited[deleteNode] =true;
                continue;
            }
            if(A[nowNode].size()==0)
                answer++;
            for(int newNode: A[nowNode]) {

                
                if(visited[newNode] == false) {
                    visited[newNode] = true;
                    queue.add(newNode);
                }
            }
        }

   }

}