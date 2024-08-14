import java.io.*;
import java.util.*;

public class Main {

    static char arr[][];
    static int answer[][];
    static int H,W;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            int cur = 5;
            while(cur <= N) {
                count += N/cur;
                cur *= 5;
            }

            sb.append(count+"\n");
        }

        System.out.println(sb);
    }

}
