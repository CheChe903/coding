import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N+1];
        int arr2[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] =arr2[i-1] + arr[i];
        }
        Arrays.sort(arr);
        //1 2 3 4
        //1 1 1 2 2 2 3  3  4  5
        //1 2 3 5 7 9 12 15 19 24
        int answer = 0;
        for(int i =1; i<=N; i++) {
            
            if(arr2[i] < M)
                continue;
            if(arr2[i] == M) {
                answer++;
                continue;
            } 
            for(int j = 1; j<i; j++) {

                if(arr2[i] -arr2[j] <M) {
                    break;
                }
                else if(arr2[i] - arr2[j] == M) {
                    answer++;
                }
                    
            }

        }
        System.out.println(answer);
    }


}