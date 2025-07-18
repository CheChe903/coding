import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[] value = new int[N];
            int[] count = new int[N];
            int[] answer = new int[N];
            List<List<Integer>> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                value[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                count[e]++;
                list.get(v).add(e);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if (count[i] == 0) {
                    queue.add(i);
                    answer[i] = value[i];
                }
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : list.get(now)) {
                    count[next]--;
                    answer[next] = Math.max(answer[next], answer[now] + value[next]);
                    if (count[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            int target = Integer.parseInt(br.readLine()) - 1;
            sb.append(answer[target]).append("\n");
        }

        System.out.println(sb);
    }
}
