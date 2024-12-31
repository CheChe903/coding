import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int N,answer;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        answer = 0;
       for(int i =0; i<N; i++) {
            String input = br.readLine();
            for(int j =0; j<N; j++) {
                arr[i][j] = input.charAt(j);
            }
       }

       for(int i =0; i<N; i++) {
            for(int j =0; j<N; j++) {
                if(j+1 <N) {
                    swap(i, j, i, j+1);
                    check();
                    swap(i, j, i, j+1);
                }

                if(i+1<N) {
                    swap(i, j, i+1, j);
                    check();
                    swap(i, j, i+1, j);
                }

            }
       }

       System.out.println(answer);

    }

    static void swap(int startX, int startY, int endX, int endY) {
        char temp = arr[startX][startY];
        arr[startX][startY] = arr[endX][endY];
        arr[endX][endY] = temp;
    }
    static void check() {

        for(int i =0; i<N; i++) {
            int count = 1;

            for(int j =0; j<N-1;j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    count+=1;
                    answer = Math.max(answer,count);
                }
                else {
                    count=1;
                }
            }
        }

        for(int i =0; i<N; i++) {
            int count =1;

            for(int j =0; j<N-1; j++) {
                if(arr[j][i] == arr[j+1][i]) {
                    count+=1;
                    answer= Math.max(answer,count);
                }
                else {
                    count=1;
                }
            }
        }
    }
}