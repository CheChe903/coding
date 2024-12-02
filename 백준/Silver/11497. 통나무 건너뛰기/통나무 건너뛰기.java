import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            int[] logs = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                logs[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(logs);
            
            int[] arranged = new int[N];
            
            int left = 0, right = N - 1;
            for (int i = 0; i < N; i++) {

                if(i%2 ==0) {
                    arranged[left++] = logs[i];
                }
                else {
                    arranged[right--] = logs[i];
                }
            }
            int difficulty = 0;
            for (int i = 0; i < N; i++) {
                int diff = Math.abs(arranged[i] - arranged[(i + 1) % N]);
                difficulty = Math.max(difficulty, diff);
            }
            sb.append(difficulty).append("\n");            
        }
        
        System.out.println(sb);
    }
}