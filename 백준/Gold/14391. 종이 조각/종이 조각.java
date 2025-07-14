import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int N,M;
    static int paper[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for(int i =0;i <N; i++) {
            String str = br.readLine();
            for(int j =0; j<M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }
        int ans = 0;
        for(int s = 0; s< (1 << (N*M)); s++) {
            int sum = 0;
            for(int i = 0;i <N; i++) {
                int cur = 0;
                for(int j =0; j<M; j++) {
                    int k = i*M+j;
                    if((s & (1 << k)) == 0) {
                        cur *=10;
                        cur += paper[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for(int j =0; j<M; j++) {
                int cur = 0;
                for(int i = 0; i<N; i++) {
                    int k = i*M+j;
                    if((s & (1 <<k)) !=0) {
                        cur *=10;
                        cur += paper[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ans = Math.max(sum, ans);
        }

        System.out.println(ans);
    }

}