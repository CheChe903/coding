import java.io.*;
import java.util.*;

public class Main {

    static int arr[][];
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        arr = new int[T + 1][9]; 

        for (int i = 1; i <= T; i++) {
            String input = br.readLine();
            for (int j = 1; j <= 8; j++) {
                arr[i][j] = input.charAt(j - 1) - '0'; 
            }
        }

        int K = Integer.parseInt(br.readLine());

      
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tIndex = Integer.parseInt(st.nextToken());
            int tDir = Integer.parseInt(st.nextToken());

            int[] visited = new int[T + 1]; 
            dfs(tIndex, tDir, visited); 
        }

        int answer = 0;
        for (int i = 1; i <= T; i++) {
            if (arr[i][1] == 1) answer++;
        }
        System.out.println(answer);
    }

   
    static void dfs(int tIndex, int tDir, int[] visited) {
        visited[tIndex] = 1;
        int leftIndex = arr[tIndex][7]; 
        int rightIndex = arr[tIndex][3]; 

        
        rotate(tIndex, tDir);

        
        if (tIndex - 1 >= 1 && visited[tIndex - 1] == 0 && arr[tIndex - 1][3] != leftIndex) {
            dfs(tIndex - 1, -tDir, visited);
        }

       
        if (tIndex + 1 <= arr.length - 1 && visited[tIndex + 1] == 0 && arr[tIndex + 1][7] != rightIndex) {
            dfs(tIndex + 1, -tDir, visited);
        }
    }

    
    static void rotate(int tIndex, int tDir) {
        if (tDir == 1) { 
            int temp = arr[tIndex][8];
            for (int i = 8; i > 1; i--) {
                arr[tIndex][i] = arr[tIndex][i - 1];
            }
            arr[tIndex][1] = temp;
        } else { 
            int temp = arr[tIndex][1];
            for (int i = 1; i < 8; i++) {
                arr[tIndex][i] = arr[tIndex][i + 1];
            }
            arr[tIndex][8] = temp;
        }
    }
}
