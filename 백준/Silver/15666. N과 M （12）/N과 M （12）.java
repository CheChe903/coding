import java.io.*;
import java.util.*;


public class Main {
    static int N,M,arr[];
    static int printArr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        printArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        back(0,0);

        System.out.println(sb);
    }

    static void back(int depth, int index) {
        if(depth == M) {
            for(int i =0; i<M; i++) {
                sb.append(printArr[i]).append(" ");

            }
            sb.append("\n");
            return;
        }
        int before = -1;
        for(int i = index; i<N; i++) {
            int now = arr[i];
            if(before != now) {
                printArr[depth] = arr[i];
                before = now;
                back(depth+1, i);
            }
        }


    }
}

