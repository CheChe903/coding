import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int count = 0; 
        int ans = Integer.MAX_VALUE;
        
        while(right < N) {
            if(arr[right] == 1) {
                count++;
            }
            
            while(count == K) {
                ans = Math.min(ans, right - left + 1);
                if(arr[left] == 1) {
                    count--;
                }
                left++;
            }
            
            right++;
        }
        
        // 결과 출력
        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}