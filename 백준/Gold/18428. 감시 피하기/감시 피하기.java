import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char arr[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr= new char[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }
        if(back(0,0,0)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    static boolean back(int value, int currentX, int currentY) {
        if(value == 3) {
            return check();
        }
        for(int i =currentX;i <N; i++) {
            int jStart = (i == currentX ? currentY :0);
            for(int j =jStart; j<N; j++) {
                if(arr[i][j] == 'X') {
                    arr[i][j] = 'O';
                    if(back(value+1, i, j+1)) {
                        return true;
                    }
                    arr[i][j] = 'X';
                }
            }
        }

        return false;
    }

    static boolean check() {
        for(int i =0; i<N; i++) {
            for(int j =0; j<N; j++) {
                if(arr[i][j]=='T') {
                    for(int x= i-1; x>=0; x--) {
                        if(arr[x][j] == 'O') {
                            break;
                        }
                        if(arr[x][j] == 'S') {
                            return false;
                        }
                    }
                    for(int x= i+1; x<N; x++) {
                        if(arr[x][j] == 'O') {
                            break;
                        }
                        if(arr[x][j] == 'S') {
                            return false;
                        }
                    }
                    for(int x= j-1; x>=0; x--) {
                        if(arr[i][x] == 'O') {
                            break;
                        }
                        if(arr[i][x] == 'S') {
                            return false;
                        }
                    }
                    for(int x= j+1; x<N; x++) {
                        if(arr[i][x] == 'O') {
                            break;
                        }
                        if(arr[i][x] == 'S') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
