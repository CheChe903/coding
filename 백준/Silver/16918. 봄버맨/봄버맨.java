import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    static char arr[][];
    static int bombSize;
    static Queue<int[]> bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        bomb = new LinkedList<>();
        bombSize = 0;
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int sec = 1;
        while(sec < N) {
            int dx[] = {-1, 1, 0, 0, 0};
            int dy[] = {0, 0, -1, 1, 0};
            
            if(!bomb.isEmpty()) {
                sec+=1;
            }
            while (!bomb.isEmpty()) {
                int now[] = bomb.poll();
                int nowx = now[0];
                int nowy = now[1];

                for (int k = 0; k < 5; k++) {
                    int nx = nowx + dx[k];
                    int ny = nowy + dy[k];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        arr[nx][ny] = '.';
                    }
                }
            }
            if(sec >=N)
                break;
            for(int i =0; i<R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] == 'O') {
                        bombSize += 1;
                        bomb.add(new int[]{i, j});
                    } else if (arr[i][j] == '.') {
                        arr[i][j] = 'O';
                    }
                }
            }

            sec+=1;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}