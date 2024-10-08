import java.io.*;
import java.util.*;

public class Main {

    static HashSet<String> set;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int arr[][];
    static int selected[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        arr = new int[5][5];
        selected = new int[6];
        for(int i =0; i<5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        set = new HashSet<>();
        for(int i =0;i <5; i++) {
            for(int j =0; j<5; j++) {
                dfs(i,j,0);
            }
        }
        System.out.println(set.size());
    }   

    static void dfs(int indexX, int indexY, int depth) {

        if(depth == 6) {
            String cur ="";

            for(int i =0; i<6; i++) {
                cur += Integer.toString(selected[i]);
            }

            set.add(cur);
            return;
        }

        for(int i =0; i<4; i++) {
            int nowx = indexX + dx[i];
            int nowy = indexY + dy[i];

            if(nowx >=0 && nowy >=0 && nowx <5 && nowy <5) {
                selected[depth] = arr[nowx][nowy];
                dfs(nowx,nowy, depth+1);
            }
        }
    }


}
