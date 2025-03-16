import java.io.*;
import java.util.*;

public class Main {

    static int arr[][];

    static int dy[] = {-1,1};
    static int N,M;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M; i++) {
            int height = Integer.parseInt(st.nextToken());
            for(int j =N-1; j > N-1-height; j--) {
                arr[j][i] = 1;
            }
        }

        for(int i=N-1; i>=0; i--) {
            for(int j = M-1; j>=0; j--) {
                if(arr[i][j]== 0) {
                    bfs(i,j);
                }
            }

        }


        System.out.println(answer);
        // 0 0 0 0 1 0 0 0
        // 1 2 2 1 1 0 0 0
        // 1 2 1 1 1 2 2 1
        // 1 1 1 1 1 1 1 1
    }

    static void bfs(int x, int y) {
        
        boolean check1 = false;
        boolean check2 = false;

        for(int j = y; j<M; j++) {
            if(arr[x][j] == 1) {
                check1 = true;                
                break;
            } 
        }
        for(int j = y; j>=0; j--) {
            if(arr[x][j] == 1) {
                check2 = true;
                break;
            }
        }

        if(check1 && check2) {
            arr[x][y] = 2;
            answer+=1;
        }
    }


}