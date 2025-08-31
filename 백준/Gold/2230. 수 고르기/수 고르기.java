import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int[] list = new int[N];

        for(int i =0; i<N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        int start = 0;
        int end = 0;
        int answer = Integer.MAX_VALUE;

        while (end < N && start < N) {
            int diff = list[end] - list[start];

            if (diff >= M) {
                answer = Math.min(answer, diff);
                start++;
            } else {
                end++;
            }
        }
        System.out.println(answer);
    }
}
