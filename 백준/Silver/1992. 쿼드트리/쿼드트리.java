import java.io.*;
import java.util.*;

public class Main {

    static int arr[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i =0; i<N; i++) {
            String str = br.readLine();
            for(int j = 0; j<N; j++) {
                arr[i][j] = str.charAt(j) -'0';
            }

        }

        quadTree(0, 0, N);

        System.out.println(sb);

    }

    public static void quadTree(int x, int y, int size) {

        if(check(x,y,size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append("(");
        
        int newSize = size/2;
        quadTree(x, y, newSize);
        quadTree(x,y+newSize,newSize);
        quadTree(x+newSize,y,newSize);
        quadTree(x+newSize,y+newSize,newSize);
    

        sb.append(")");
    }


    public  static boolean check(int x, int y, int size) {

        int cur = arr[x][y];

        for(int i = x; i < x+size; i++) {
            for(int j = y; j<y+size; j++) {
                if(cur != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
