import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<n; i++)
        {
            int arr[] = new int[5];
            int cur = Integer.parseInt(br.readLine());
            
            arr[0] = cur/60;
            cur = cur%60;

            if(cur <=35)
            {
                if(cur%10 >5)
                {
                    arr[1] +=cur/10 +1;
                    arr[4] += 10 - cur%10;
                }
                else
                {
                    arr[1] +=cur/10;
                    arr[3] += cur%10;

                }
            }
            else
            {
                arr[0]++;

                if(cur%10 >=5)
                {
                    arr[2] += 6- (cur/10+1);
                    arr[4] += 10 - cur %10;
                }
                else
                {
                    arr[2] +=6 - cur/10;
                    arr[3] +=cur%10;
                }
            }

            for(int j =0; j<5; j++)
            {
                sb.append(arr[j]).append(" ");
            }
            if(i != n-1)
                sb.append("\n");

        }

        System.out.println(sb);
    }

   
}
