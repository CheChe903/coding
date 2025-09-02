import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int down[] = new int[N/2];
        int up[] = new int[N/2];

        for(int i =0; i<N/2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int best = Integer.MAX_VALUE;
        int bestCount = 0;

        for(int i =1; i<=H; i++) {
            int downHit = down.length - lowerBound(down, i);
            int upHit = up.length - lowerBound(up, H-i+1);
            int hit = downHit + upHit;

            if(hit < best) {
                best = hit;
                bestCount = 1;
            }
            else if(best == hit) {
                bestCount +=1;
            }
        }   
        System.out.println(best +" " + bestCount);
    }
    
    static int lowerBound(int[] arr, int value) {
        int answer = 0;
        int length = arr.length;

        while(answer < length) {
            int m = (answer + length) >>> 1;
            if(arr[m] >= value) length = m;
            else answer = m +1;
        }
        return answer;
    }
}
