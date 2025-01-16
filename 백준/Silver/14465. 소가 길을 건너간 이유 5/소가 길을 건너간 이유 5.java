import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean point[] = new boolean[n+1];
        for(int i =1; i<=b; i++) {
            point[Integer.parseInt(br.readLine())] = true;
        }


        int cnt = 0;

        for(int i =1; i<=k; i++) {
            if(point[i]) cnt++;
        }

        int answer = cnt;


        for(int i =2; i<= n-k+1; i++) {
            if(point[i-1]) cnt--;
            if(point[i+k-1]) cnt++;
            answer = Math.min(answer,cnt);
        }

        System.out.println(answer);


    }
    
}
