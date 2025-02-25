import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2,n);

        dfs(size,r,c);

        System.out.println(count);
    }

    static void dfs(int size, int x, int y) {
        
        if(size ==1)
            return;
        
        if(x< size/2 && y < size/2) {
            dfs(size/2, x,y);

        }
        else if(x< size/2 && y>= size/2) {
            count += size * size/4;
            dfs(size/2,x,y-size/2);
        }
        else if(x >=size/2 && y<size/2) {
            count += (size * size/4) *2;
            dfs(size/2, x- size/2, y);
        }
        else {
            count +=(size * size/4 )* 3;
            dfs(size/2, x-size/2, y-size/2);
        }
    }
}