import java.io.*;
import java.util.*;

public class Main {
 

    static int dx[] = {0,1};
    static int dy[] = {1,0};
    static int arr[][];
    static int N,M;
    static int[][] candy;
	public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        candy = new int[N+1][M+1];

        for(int i =1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =1; i<=N; i++) {
            for(int j =1; j<=M; j++) {
                
                candy[i][j] = Math.max(candy[i-1][j-1], Math.max(candy[i-1][j], candy[i][j-1]))+ arr[i][j];
            }
        }

        System.out.println(candy[N][M]);
	}
 
}
