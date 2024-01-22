import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;


public class Main {
	public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                
                int[] arr = new int[N];
                
                StringTokenizer st =new StringTokenizer(br.readLine(), " ");

                for(int i =0; i<N; i++)
                {
                        arr[i]= Integer.parseInt(st.nextToken());
                }

                int M = Integer.parseInt(br.readLine());

                StringTokenizer st2 =new StringTokenizer(br.readLine(), " ");

                int[] hash = new int[M];
                
                for(int i =0; i<M; i++)
                {
                        hash[i]= Integer.parseInt(st2.nextToken());
                }
                
                HashMap<Integer, Integer> rank = new HashMap<Integer, Integer>();

                for(int v : arr)
                {
                        rank.put(v,v);
                }
                StringBuilder sb = new StringBuilder();


                for(int v : hash)
                {
                        if(rank.containsKey(v))
                        {
                                sb.append(1).append(' ');

                        }
                        else
                        {
                                sb.append(0).append(' ');
                        }
                }

                System.out.println(sb);
        }


}