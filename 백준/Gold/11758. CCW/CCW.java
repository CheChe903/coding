import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1X = Integer.parseInt(st.nextToken());
        int p1Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p2X = Integer.parseInt(st.nextToken());
        int p2Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p3X = Integer.parseInt(st.nextToken());
        int p3Y = Integer.parseInt(st.nextToken());

        long crossProduct = (long)(p2X - p1X) * (p3Y - p1Y) - (long)(p2Y - p1Y) * (p3X - p1X);


        if (crossProduct > 0) {
            System.out.println(1);
        } else if (crossProduct < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
}