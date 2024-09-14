import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());  
        long Y = Long.parseLong(st.nextToken());  

        long start = 1;
        long end = 1_000_000_000; 
        long cur = (Y * 100) / X; 
        long answer = -1;

        if (cur >= 99) {
            System.out.println(-1);
            return;
        }

        while (start <= end) {
            long mid = (start + end) / 2;

            long cur2 = ((Y + mid) * 100) / (X + mid);  

            if (cur == cur2) {  
                start = mid + 1;
            } else {  
                answer = mid;  
                end = mid - 1; 
            }
        }

       
        System.out.println(answer);
    }
}
