import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb =new StringBuilder();
        for(int i =0; i<n; i++)
        {
            String str = br.readLine();

            int check;
            check = function(str, 0, str.length()-1, 0);

            sb.append(check).append("\n");
        }

        System.out.println(sb);
    }
    public static int function(String str, int start, int end, int delete)
    {

        while(start<=end)
        {
            if(str.charAt(start) != str.charAt(end))
            {
                if(delete==0)
                {
                    if(function(str, start+1, end, 1) ==0|| function(str, start, end-1, 1) ==0) return 1;
                    return 2;
                }
                else
                    return 2;
            }
            else
            {
                start++;
                end--;
            }
        }
        return 0;
    }

}
