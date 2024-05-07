import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        int cur =0;
        int per = 0;
        int answer = 0;
        int visited[] = new int[str.length()+1];
        for(int i =0; i<str.length(); i++)
        {
            if(str.charAt(i) == 'P')
                per++;
        }
        while(cur != n)
        {
            if(str.charAt(cur) == 'P')
            {
                int start = cur-k;
                int end = cur+k;
                if(start<0)
                    start =0;
                if(end>=n)
                    end =n-1;
                for(int i = start; i<=end; i++)
                {
                    if(str.charAt(i)== 'H' && visited[i] == 0)
                    {
                        visited[i] =1;
                        per --;
                        answer++;
                        
                        break;
                    }
                }
                    
            }

            cur++;
        }

        System.out.println(answer);
    }

   
}
