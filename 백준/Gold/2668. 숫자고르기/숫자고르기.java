import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> list;
    static int[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        num = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int n : list) {
            System.out.println(n);
        }
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = num[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int i = next; i != cur; i = num[i]) {
                list.add(i);
            }
            list.add(cur);
        }

        finished[cur] = true;
    }
}
