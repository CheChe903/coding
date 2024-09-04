import java.io.*;
import java.util.*;

public class Main {

    static int arr[];
    static int K;
    static String []answer;
    public static void main(String[] args) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        K = Integer.parseInt(br.readLine());
        answer = new String[K+1];
        int size = pow(K);
        arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
        }

        for(int i =1; i<=K; i++) {
            answer[i] ="";
        }
        dfs(1, arr.length-1, 1);

        for(int i =1; i<=K; i++) {
            System.out.println(answer[i]);
        }

    }
    static int pow(int k ) {
        int answer = 2;
        for(int i =1; i<k; i++) {
            answer *=2;
        }

        return answer;
    }

    static void dfs(int s, int e, int floor) {

        if(floor == K+1)
            return;

        int mid = (s+e)/2;

        answer[floor] += arr[mid] +" ";
        dfs(s, mid-1, floor +1);
        dfs(mid+1, e , floor+1);


    }


}