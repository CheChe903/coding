import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int arr[] = new int[S];
        long end = Integer.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
            sum += arr[i];
        }

        long answer = 0;
        long start = 1;
        while(start <= end) {
            long mid = (start + end) / 2;
            int count = 0;

            for(int i = 0; i < S; i++) {
                count += arr[i] / mid;
            }

            if(count >= C) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(sum - end *(long) C);
    }
}
