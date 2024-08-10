import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer =0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start =1;
        int end = M;
        int j = Integer.parseInt(br.readLine());

        for(int i =0; i<j; i++)
        {
            int cur = Integer.parseInt(br.readLine());
            if(cur>end)
            {
                start += cur - end;
                answer += cur -end;
                end =  cur;

            }
            else if(cur < start)
            {
                end -= start -cur;
                answer +=start-cur;
                start = cur;

            }
        }

        System.out.println(answer);
    }
}