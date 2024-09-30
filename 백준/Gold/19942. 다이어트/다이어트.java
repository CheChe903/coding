import java.io.*;
import java.util.*;

public class Main {

    static boolean visited[];
    static int correct[];
    static int arr[][];
    static int curValue[];
    static int answer,N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][6];

        StringTokenizer st = new StringTokenizer(br.readLine());

        correct = new int[5];
        curValue =  new int[5];
        answer = Integer.MAX_VALUE;
        for(int i =1; i<=4;i ++) {
            correct[i] = Integer.parseInt(st.nextToken());
        }
        visited= new boolean[N+1];
        sb= new StringBuilder();
    
        for(int i =1;i <=N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j =1; j <=5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,0);
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else
            System.out.println(sb);
    }

    static void dfs(int start, int curPrice) {

        int count = 0;
        for(int i =1; i<=4; i++) {
            if(curValue[i] >= correct[i])
                count++;
        }
        if(count ==4) {
            check(curPrice);
        }


        for(int i =start; i<=N; i++) {
            if(visited[i] == false) {
                if (curPrice + arr[i][5] >= answer) {
                    continue;
                }

                for(int j=1; j<=4; j++) {
                    curValue[j] += arr[i][j];
                }
                visited[i]= true;
                dfs(start+1,curPrice + arr[i][5]);
                visited[i]=false;
                for(int j=1; j<=4; j++) {
                    curValue[j] -= arr[i][j];
                }
            }
        }

    }


    static void check(int curPrice) {

        if(answer > curPrice) {
            sb = new StringBuilder();
            sb.append(curPrice).append("\n");
            answer= curPrice;
            for(int i =1; i<=N; i++) {
                if(visited[i]) {
                    sb.append(i).append(" ");
                }
            }
        }
    }
}