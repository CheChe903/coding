import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    static int N, M;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        
        int maxCash = 0; 
        int minCash = 0; 

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxCash += arr[i];
            minCash = Math.max(minCash, arr[i]);
        }

       
        answer = binarySearch(minCash, maxCash);

        System.out.println(answer);
    }

    static int binarySearch(int start, int end) {
        int low = start;
        int high = end;
        int answer = high;

        while (low <= high) {
            int mid = (low + high) / 2; 
            int count = 1; 
            int curCash = mid; 

            for (int i = 0; i < N; i++) {
                if (curCash < arr[i]) {
                   
                    count++;
                    curCash = mid;
                }
                curCash -= arr[i];
            }

            
            if (count > M) {
                low = mid + 1;
            } else {
            
                answer = mid;
                high = mid - 1;
            }
        }

        return answer;
    }
}
