import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];

        Map<String, Integer> patterns = new HashMap<>();
        for(int i =0; i<N; i++) {
            String input = br.readLine();
            patterns.put(input, patterns.getOrDefault(input, 0)+1);
        }
        int K = Integer.parseInt(br.readLine());
        int answer = 0;
        for(String pattern: patterns.keySet()) {
            int zeroCnt = 0;
            for(char c : pattern.toCharArray()) {
                if(c == '0') {
                    zeroCnt+=1;
                }
            }

            if(zeroCnt > K) {
                continue;
            }
            if((K - zeroCnt) %2 !=0) {
                continue;
            }

            answer = Math.max(answer, patterns.get(pattern));
        }
        System.out.println(answer);
        
    }
}