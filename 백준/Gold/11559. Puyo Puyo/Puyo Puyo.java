import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[][] check;
    static boolean[][] visited;
    static char map[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map= new char[12][6];

        for(int i =0; i<12; i++) {
            String input = br.readLine();

            for(int j =0; j< 6; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        
        int answer = 0;

        while(true) {
            check = new boolean[12][6];
            visited = new boolean[12][6];
            for(int i = 11; i>=0; i--) {

                for(int j =0; j<6; j++) {
                    if(map[i][j] != '.' && !visited[i][j]) {
                        bfs(i,j);
                    }
                }
            }
            boolean breakCheck = false;
            for(int i = 11; i>=0; i--) {

                for(int j =0; j<6; j++) {
                    if(check[i][j]) {
                        breakCheck = true;
                        map[i][j] = '.';
                    }
                }
            }

            if(!breakCheck) {
                break;
            }
            answer+=1;
            
            for(int i = 11; i>=0; i--) {

                for(int j =0; j<6; j++) {
                    if(map[i][j] =='.') {
                        int temp = i-1;

                        for(int k = temp; k>=0; k--) {
                            if(map[k][j] != '.') {
                                map[i][j] = map[k][j];
                                map[k][j] = '.';
                                break;
                            }
                        }

                    }
                }
            }
            // System.out.println();
            // for(int i = 0; i<=11; i++) {

            //     for(int j =0; j<6; j++) {
            //             System.out.print(map[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
    
        System.out.println(answer);

    }

    public static void bfs(int x, int y) {
        int count =1; 

        char target = map[x][y];

        Queue<int []> queue = new LinkedList<>();
        Queue<int []> queue1 = new LinkedList<>();
        queue.add(new int[] { x,y});
        queue1.add(new int[] { x,y});

        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int now [] = queue.poll();

            int nowx = now[0];
            int nowy = now[1];

            for(int i =0; i<4; i++) {
                int nx = nowx  +dx[i];
                int ny = nowy+ dy[i];

                if(nx >=0 && nx<12 && ny>=0 && ny<6) {
                    if(map[nx][ny] == target &&!visited[nx][ny]) {
                        visited[nx][ny] =  true;
                        count+=1;
                        queue.add(new int[] {nx,ny});
                        queue1.add(new int[] {nx,ny});
                    }
                }
            }
        }
        if(count>=4) {
            while(!queue1.isEmpty()) {
                int now[] = queue1.poll();
                check[now[0]][now[1]] = true;
            }
        }
    }
}