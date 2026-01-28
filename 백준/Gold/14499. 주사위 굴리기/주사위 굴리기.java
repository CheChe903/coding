import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> dice;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int map[][] = new int[N][M];

        dice = new ArrayList<>();

        for(int i =0; i<=5; i++) {
            dice.add(0);
        }

        for(int i =0; i<N; i++)  {
            st = new StringTokenizer(br.readLine());

            for(int j =0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            if(dir == 1) {
                if(y +1 >= M) {
                    continue;
                }
                east();
                y+=1;
            } else if(dir ==2) {
                if(y -1 < 0) {
                    continue;
                }
                west();
                y-=1;
            } else if (dir ==3) {
                if(x -1 < 0) {
                    continue;
                }
                north();
                x-=1;
            } else {
                if(x +1 >=N) {
                    continue;
                } 
                south();
                x+=1;
            }

            if(map[x][y] == 0) {
                map[x][y] = dice.get(5);
            } else {
                dice.set(5, map[x][y]);
                map[x][y] = 0;
            }

            sb.append(dice.get(0)).append("\n");
            
        }

        System.out.println(sb);
    }

    public static void south() {
        //위 - > 북 -> 아래 -> 서 -> 위
        int up = dice.get(0);
        int north = dice.get(4);
        int down = dice.get(5);
        int west = dice.get(2);
        
        dice.set(4, up);
        dice.set(5, north);
        dice.set(2, down);
        dice.set(0, west);
    }

    public static void west() {
        //위 -> 남 -> 아래 -> 동 -> 위
        int up = dice.get(0);
        int south = dice.get(3);
        int down = dice.get(5);
        int east = dice.get(1);
        
        dice.set(3, up);
        dice.set(5, south);
        dice.set(1, down);
        dice.set(0, east);
    }

    public static void east() {
        //위 - > 동 -> 아래 -> 남 -> 위
        int up = dice.get(0);
        int east = dice.get(1);
        int down = dice.get(5);
        int south = dice.get(3);
        
        dice.set(1, up);
        dice.set(5, east);
        dice.set(3, down);
        dice.set(0, south);
    }

    public static void north() {
        //위 - > 서 -> 아래 -> 북 -> 위
        int up = dice.get(0);
        int west = dice.get(2);
        int down = dice.get(5);
        int north = dice.get(4);
        
        dice.set(2, up);
        dice.set(5, west);
        dice.set(4, down);
        dice.set(0, north);
    }
}