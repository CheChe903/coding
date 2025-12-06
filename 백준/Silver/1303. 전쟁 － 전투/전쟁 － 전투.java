import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] arr;
    static boolean visited[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for(int i =0; i<N; i++) {
            String input = br.readLine();
            for(int j =0; j<M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        int answerW = 0;
        int answerB = 0;
        visited = new boolean[N][M];
        for(int i =0; i<N; i++) {
            for(int j =0; j<M; j++) {
                int count = 0;
                if(visited[i][j] == false) {
                    count = bfs(i,j, arr[i][j]);
                }
                if(arr[i][j] == 'W') {
                    answerW += Math.pow(count,2);
                } else {
                    answerB += Math.pow(count, 2);
                }
            }
        } 
        System.out.println(answerW + " " +answerB);
    }

    static int bfs(int x, int y, char target) {
        int count = 0;

        Queue<int[] > queue = new LinkedList<>();
        queue.add(new int[] { x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            count+=1;
            int now[] = queue.poll();
            int nowx = now[0];
            int nowy= now[1];

            for(int i =0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=0 && nx <N && ny>=0 && ny<M) {
                    if(!visited[nx][ny] && arr[nx][ny] == target) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return count;
    }
}