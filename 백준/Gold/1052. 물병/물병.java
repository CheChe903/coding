import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (Integer.bitCount(N) <= K) {
            System.out.println(0);
            return;
        }

        int cur = N;
        int buy = 0;

        while (Integer.bitCount(cur) > K) {
            int lsb = cur & -cur;
            buy += lsb;
            cur += lsb;
        }

        System.out.println(buy);
    }
}