import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
        
	public static void main(String[] args) throws IOException 
        {

                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

                int N = Integer.parseInt(br.readLine());
                int []arr =new int[N];

                StringTokenizer st = new StringTokenizer(br.readLine()); 
                for(int i =0; i<N ; i++)
                {
                        arr[i] = Integer.parseInt(st.nextToken());
                }
                int M = Integer.parseInt(br.readLine());

                Arrays.sort(arr);

                st = new StringTokenizer(br.readLine());
                StringBuilder sb =new StringBuilder();
                for(int i =0; i<M; i++)
                {
                        int cur = Integer.parseInt(st.nextToken());
                        boolean find =false;

                        int start =0;
                        int end = arr.length -1;

                        while(start<=end)
                        {
                                int mid = (start+end)/2;
                                int midv = arr[mid];
                                if(midv>cur)
                                {
                                        end = mid-1;
                                }
                                else if(midv<cur)
                                {
                                        start = mid+1;
                                }
                                else
                                {
                                        find=true;
                                        break;
                                }
                        }
                        if(find)
                                sb.append("1").append("\n");
                        else
                                sb.append("0").append("\n");
                }

                System.out.println(sb);

                



        }




}


