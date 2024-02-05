import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
        
	public static void main(String[] args) throws IOException 
        {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int N = Integer.parseInt(br.readLine());

                PriorityQueue<Integer> pq =new PriorityQueue<>();
                int ans =0;
                int[] arr = new int[N];
                for(int i =0; i<N; i++)
                {
                        pq.add(Integer.parseInt(br.readLine()));
                }
                int check=0;
                int k =0;
                while(!pq.isEmpty())
                {                        
                        k+=pq.poll();
                        check++;
                        if(check==2)
                        {
                                
                                ans +=k;
                                if(pq.isEmpty())
                                {
                                        break;
                                }
                                pq.add(k);
                                k=0;
                                check=0;
                        }


                }
                System.out.println(ans);

        }




}


