import java.io.*;
import java.lang.reflect.Array;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n,k;

        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int arr[] =new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++)
        {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        boolean check[] = new boolean[n];
        int answer =0;
        for(int i =0; i<k; i++)
        {
            int max =0;
            int index =0;
            for(int j =0; j<n; j++)
            {
                if(max<arr[j] && !check[j])
                {
                    max = arr[j];
                    index =j;
                }
            }

            check[index]= true;
            answer += max-i;
        }


        System.out.println(answer);
    }

   
}
