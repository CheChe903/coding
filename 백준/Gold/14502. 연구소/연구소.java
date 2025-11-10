import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int answer;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer =0;

        int arr[][] = new int[N][M];

        for(int i =0; i<N; i++) {
            st =new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0,arr);

        System.out.println(answer);
    }

    static void backtracking(int wallCount, int arr[][]) {
        if(wallCount == 3) {
            checkAnswer(arr);
            return;
        }

        for(int i =0; i<N; i++) {
            for(int j =0; j<M; j++) {
                if(arr[i][j] ==0) {
                    arr[i][j] = 1;
                    backtracking(wallCount+1, arr);
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void checkAnswer(int arr[][]) {
    // 배열 복사
    int temp[][] = new int[N][M];
    for(int i = 0; i < N; i++) {
        temp[i] = arr[i].clone();
    }
    
    Queue<int[]> queue = new LinkedList<>();
    
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(temp[i][j] == 2) {
                queue.add(new int[] {i, j});
            }
        }
    }
    
    while(!queue.isEmpty()) {
        int now[] = queue.poll();
        int nowx = now[0];
        int nowy = now[1];
        
        for(int i = 0; i < 4; i++) {
            int nx = nowx + dx[i];
            int ny = nowy + dy[i];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && temp[nx][ny] == 0) {
                temp[nx][ny] = 2;  // 복사본 수정
                queue.add(new int[] {nx, ny});
            }
        }
    }
    
    int count = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(temp[i][j] == 0) {
                count++;
            }
        }
    }
    answer = Math.max(answer, count);
}
}