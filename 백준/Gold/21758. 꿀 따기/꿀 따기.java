import java.io.*;
import java.lang.reflect.Array;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int sum[] = new int[n];
        int reversesum[] = new int[n];

        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0]= arr[0];
        reversesum[n-1] = arr[n-1];
        for(int i =1; i<n; i++)
        {
            sum[i]= sum[i-1] +arr[i];
        }

        for(int i =n-2; i>=0; i--)
        {
            reversesum[i] = reversesum[i+1] +arr[i];
        }
        int firstbee =0;
        int secondbee =0;
        int honey =0;
        int answer=0;

        for(int i =1; i<n-1; i++)
        {
            firstbee = sum[i] -sum[0];
            secondbee = reversesum[i] - reversesum[n-1];

            if(answer < firstbee+ secondbee)
                answer=firstbee+secondbee;
            
            
            firstbee = sum[n-1] - sum[0] - arr[i];
            secondbee = sum[n-1] - sum[i];

            if(answer < firstbee+ secondbee)
                answer=firstbee+secondbee;


            firstbee = reversesum[0] - reversesum[n-1] -arr[i];
            secondbee = reversesum[0] - reversesum[i];

            if(answer < firstbee+ secondbee)
                answer=firstbee+secondbee;

        }

        System.out.println(answer);
    }

   
}
