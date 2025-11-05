import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static String bfs(int A, int B) {
        int visited[] = new int[10000];
        String visitedString[] = new String[10000];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(visitedString, "");
        Arrays.fill(visited, -1);
        queue.add(A);
        visited[A] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == B) {
                break;
            }
            int D = D(now);
            if(visited[D] == -1) {
                visited[D] = visited[now]+1;
                visitedString[D] = visitedString[now] +"D";
                queue.add(D);
            }
            int S = S(now);
            if(visited[S] == -1) {
                visited[S] = visited[now]+1;
                visitedString[S] = visitedString[now] +"S";
                queue.add(S);
            }
            int L = L(now);
            if(visited[L] == -1) {
                visited[L] = visited[now]+1;
                visitedString[L] = visitedString[now] +"L";
                queue.add(L);
            }
            int R = R(now);
            if(visited[R] == -1) {
                visited[R] = visited[now]+1;
                visitedString[R] = visitedString[now] +"R";
                queue.add(R);
            }
        }
        return visitedString[B];
    }
    
    static int D(int value) {
        value*=2;

        return value %10000;
    }

    static int S(int value) {
        if(value ==0) {
            return 9999;
        }
        return value-1;
    }

    static int L(int value) {
        int temp = value /1000;
        if(value /1000  ==0) {
            temp = 0;
        }
        value %=1000;
        return value * 10 + temp;
    }
    //6789
    //temp = 6

    static int R(int value) {
        int temp = value%10;

        value /=10;
        return value + (temp * 1000);
    }
}