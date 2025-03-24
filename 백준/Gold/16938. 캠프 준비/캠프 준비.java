import java.io.*;
import java.util.*;

public class Main {
    static int N,L,R,X,arr[];
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); 

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    
        dfs(0,0,0,0,0);
        System.out.println(answer);
    }

    static void dfs(int index, int value, int problemCount, int minValue, int maxValue) {
        if(index == N) {
            if(problemCount >= 2 && value >= L && value <= R && maxValue - minValue >= X) {
                answer++;
            }
            return;
        }
        
        int newMin = (problemCount == 0) ? arr[index] : Math.min(minValue, arr[index]);
        int newMax = (problemCount == 0) ? arr[index] : Math.max(maxValue, arr[index]);
        
        dfs(index + 1, value + arr[index], problemCount + 1, newMin, newMax);
        
        dfs(index + 1, value, problemCount, minValue, maxValue);
    }
}