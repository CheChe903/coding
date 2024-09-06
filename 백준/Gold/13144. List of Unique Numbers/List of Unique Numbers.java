import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt( br.readLine());
        int arr[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer =0;
        for(int i =1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean visited[] = new boolean[100002];
        for(int i =1, j =0; i<=N; i++) {

            while(j +1 <=N && visited[arr[j+1]]==false) {
                j++;
                visited[arr[j]] = true; 
            }
                
                answer+= j-i+1;
                visited[arr[i]] = false;
            
        }
        System.out.println(answer);

    }
}
