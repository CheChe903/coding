import java.io.*;
import java.util.*;

public class Main {

    static char arr[][];
    static int answer[][];
    static int H,W;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());

        W = Integer.parseInt(st.nextToken());
        
        arr = new char[H][W];
        answer = new int[H][W];

        for(int i=0; i<H; i++) {
            for(int j = 0; j<W; j++) {
                answer[i][j]= -1;
            }
        }

        for(int i=0; i<H; i++) {
            String input = br.readLine();
            for(int j = 0; j<W; j++) {
                arr[i][j] = input.charAt(j);

                if(arr[i][j]=='c')
                    answer[i][j]=0;
            }
        }

        for(int i=0; i<H; i++) {
            for(int j = 0; j<W; j++) {

                if(answer[i][j]==0 && arr[i][j]=='c') {
                    search(i,j);
                }
            }
        }
        for(int i=0; i<H; i++) {
            for(int j = 0; j<W; j++) {
                System.out.print(answer[i][j] +" ");

            }
            System.out.println();
        }

    }
    public static void search(int x, int y) {

        int cur = 1;
        while(true) {
            if(y+1 < W && answer[x][y+1] == -1) {
                answer[x][y+1]= cur;
                cur++;
                y++;
            }
            else
                break;
        }

    }

}
