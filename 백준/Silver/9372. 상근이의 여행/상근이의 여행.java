import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Main {
    static List<Integer> list[];
    static boolean visited[];
    static int parent[];
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int test = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<test; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            for(int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
            }

            sb.append(N-1).append("\n");
        }
        System.out.println(sb);
    }
}