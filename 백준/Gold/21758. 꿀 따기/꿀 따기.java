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
        

        int answer =0;
        for(int i =0; i<n; i++)
        {
            int firstbee =0;
            int secondbee =0;
            for(int j =0; j<n; j++)
            {

                if(j==i)
                    continue;
                else if(j<i)
                {
                    firstbee = sum[i] - sum[j];

                }
                else if(j>i)
                {
                    firstbee = reversesum[i] - reversesum[j];

                }
                for(int k=0; k<n; k++)
                {
                    if(k==i || k ==j)
                        continue;
                    
                    else if(k<i)
                    {
                        secondbee = sum[i] - sum[k];
                    }
                    else if(k>i)
                    {
                        secondbee = reversesum[i] - reversesum[k];
                    }
                    
                    if((j<k && k<i)|| (j>k && k>i))
                        firstbee -= arr[k];
                    else if((k<j && j<i) || (k>j && j>i))
                        secondbee -= arr[j];

                    if(firstbee + secondbee > answer)
                        answer= firstbee+ secondbee;
                    
                    if((j<k && k<i)|| (j>k && k>i))
                        firstbee += arr[k];
                }
            }

            
        }
        
        System.out.println(answer);
    }

   
}
