import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static char arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int sheep =0;
    static int wolf = 0;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st  =new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited= new boolean[R][C];

        for(int i =0; i<R; i++) {
            String input = br.readLine();
            for(int j =0; j<C; j++) {
                arr[i][j]=  input.charAt(j);
            }
        }
        for(int i =0; i<R; i++) {
            for(int j =0; j<C; j++) {
                char currentChar = arr[i][j];
                if(currentChar == '.' || currentChar == 'v' || currentChar =='o') {
                    if(visited[i][j] == false) {
                        bfs(i,j);
                    }
                }
            }
        }
        System.out.print(sheep +" " +wolf);
        
    }

    static void bfs(int x, int y) {
        int currentSheep = 0;
        int currentWolf = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]= true;

        if(arr[x][y] == 'o')
            currentSheep++;

        if(arr[x][y] =='v') {
            currentWolf++;
        }

        while(!queue.isEmpty()) {

            int now[] = queue.poll();
            int nowx = now[0];
            int nowy = now[1];

            for(int i =0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if(nx >=0 && nx <R && ny>=0 && ny <C) {
                    if(visited[nx][ny] == false && arr[nx][ny] != '#') {
                        queue.add(new int[] {nx,ny});
                        visited[nx][ny] = true;

                        if(arr[nx][ny] == 'o')
                            currentSheep++;
                        if(arr[nx][ny] == 'v') {
                            currentWolf++;
                        }
                    }
                }
            }
        }

        if(currentSheep > currentWolf) {
            sheep += currentSheep;
        }
        else {
            wolf += currentWolf;
        }
    }
}