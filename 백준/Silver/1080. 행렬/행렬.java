import java.io.*;
import java.util.*;

public class Main {

    static int [][] arr1;
    static int [][] arr2;
    static int N,M;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N][M];

        for(int i =0; i < N; i++) {
            String input = br.readLine();
            for(int j =0; j<input.length(); j++) {
                arr1[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }

        arr2 = new int[N][M];
        for(int i =0; i < N; i++) {
            String input = br.readLine();
            for(int j =0; j<input.length(); j++) {
                arr2[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }
        if(isSameMetric()) {
            System.out.println(0);
            System.exit(0);
        }

        if(N < 3 || M <3) {
            System.out.println(-1);
            System.exit(0);
        }
        int count = 0;
        for(int i =0; i<N-2; i++) {
            for(int j =0; j<M-2; j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    change(i,j);
                    count+=1;
                }
                
                if(isSameMetric()) {
                    System.out.println(count);
                    System.exit(0);
                }
        
            }
        }
        if(isSameMetric()) {
            System.out.println(count);
            System.exit(0);
        }
        System.out.println(-1);
    }

    private static void change(int x, int y) {
        for(int i = x; i< x+3; i++) {
            for(int j = y; j< y+3; j ++) {
                if(arr1[i][j] == 0) {
                    arr1[i][j] = 1;
                } else {
                    arr1[i][j] = 0;
                }
            }
        }
    }

    private static boolean isSameMetric() {
        for(int i = 0; i< N; i++) {
            for(int j = 0; j< M; j ++) {
                if(arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }  
        return true;
    }
}
