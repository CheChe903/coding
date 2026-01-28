import java.io.*;
import java.util.*;

public class Main {
    static int arr[][];
    static int bingo;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        arr = new int[5][5];
        for(int i =0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bingo = 0;
        int count = 0;
        for(int i =0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<5; j++) {
                int n = Integer.parseInt(st.nextToken());
                count+=1;
                for(int x= 0; x<5; x++) {
                    for(int y = 0; y<5; y++) {
                        if(arr[x][y] == n) {
                            arr[x][y] =0;
                        }
                    }
                }

                
                xCheck();
                yCheck();
                xyCheck();
                yxCheck();
                
                if (bingo >=3) {
                    System.out.println(count);
                    System.exit(0);
                }
                bingo=0;
            }
        }
    }

    public static void xCheck() {
        for(int i =0; i<5; i++) {
            int count = 0;

            for(int j =0; j<5; j++) {
                if(arr[i][j] ==0) {
                    count+=1;
                }
            }

            if(count ==5) {
                bingo+=1;
            }
        }
    }

    public static void yCheck() {
        for(int i =0; i<5; i++) {
            int count = 0;

            for(int j =0; j<5; j++) {
                if(arr[j][i] ==0) {
                    count+=1;
                }
            }

            if(count ==5) {
                bingo+=1;
            }
        }
    }

    public static void xyCheck() {
        int count = 0;
        for(int i=0; i<5; i++) {
            if(arr[i][i] == 0) {
                count+=1;
            }
        }

        if (count == 5) {
            bingo+=1;
        }
    }

    public static void yxCheck() {
        int count = 0;
        for(int i=0; i<5; i++) {
            if(arr[i][4-i] == 0) {
                count+=1;
            }
        }

        if (count == 5) {
            bingo+=1;
        }
    }
}