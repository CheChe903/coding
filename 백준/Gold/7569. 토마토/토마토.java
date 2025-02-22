import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        
        box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        
        // 입력 읽기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    // 익은 토마토를 큐에 추가
                    if (box[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }
                }
            }
        }
        
        // BFS로 익는 과정 시뮬레이션
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean ripened = false;
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int z = current[0];
                int y = current[1];
                int x = current[2];
                
                for (int d = 0; d < 6; d++) {
                    int nz = z + dz[d];
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    
                    if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        queue.add(new int[]{nz, ny, nx});
                        ripened = true;
                    }
                }
            }
            
            if (ripened) {
                days++;
            }
        }
        
        // 아직 익지 않은 토마토가 있는지 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        
        System.out.println(days);
    }
}