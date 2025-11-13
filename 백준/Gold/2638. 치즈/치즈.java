import java.io.*;
import java.util.*;

public class Main {

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int N,M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[][] =new int[N][M];
        int cheeseCount = 0;
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++) {   
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    cheeseCount+=1;
                }
            }
        }
        int answer =0;

        while(cheeseCount > 0) {
            List<int[]> eliminatedCheese = new ArrayList<>();

            boolean air[][] = new boolean[N][M];
            
            checkAir(arr,air);

            for(int i =0; i<N; i++) {
                for(int j =0; j<M;j++) {
                    if(arr[i][j] != 1) continue;
                    
                    int count = 0;
                    for(int k =0; k<4; k++) {
                        int nowx = i + dx[k];
                        int nowy = j + dy[k];

                        if(nowx < 0 || nowx >= N || nowy <0 || nowy>=M) {
                            continue;
                        }
                        if(air[nowx][nowy]) {
                            count+=1;
                        }
                    }
                    if(count >=2) {
                        eliminatedCheese.add(new int[] {i,j});
                    }
                }
            }
            cheeseCount-= eliminatedCheese.size();
            for(int i =0; i< eliminatedCheese.size(); i++) {
                int now[] = eliminatedCheese.get(i);

                arr[now[0]][now[1]] = 0;
            }
            answer+=1;
        }


        System.out.println(answer);
    }


    public static boolean checkAir(int arr[][], boolean air[][]) {
        
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];
        
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(!visited[nx][ny] && arr[nx][ny] != 1 && !air[nx][ny]) {
                    visited[nx][ny] = true;
                    air[nx][ny] = true;
                    queue.add(new int[] { nx,ny});
                }
            }
        }
        return false;
    }

}
// -> 결국 외부 공기를 한 번에 체크해야함.  -> 겉에 돌면서 