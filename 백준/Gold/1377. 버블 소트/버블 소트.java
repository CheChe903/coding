import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {

        static class Pair implements Comparable<Pair>{
                private int x;
                private int y;
            
                Pair(int x, int y) {
                    this.x = x;
                    this.y = y;
                }
            
                public int getX(){
                    return x;
                }
            
                public int getY(){
                    return y;
                }

                @Override
                public int compareTo(Pair P)
                {
                        return Integer.compare(this.y, P.y);
                }
            }

	public static void main(String[] args) throws IOException 
        {
  
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int N= Integer.parseInt(br.readLine());

                Pair[] pair = new Pair[N+1];
                for(int i =1; i<=N; i++)
                {
                        int yV = Integer.parseInt(br.readLine());
                        pair[i] =new Pair(i,yV);
                }
                Arrays.sort(pair,1,N+1);

                int max =-99;
                for(int i =1; i<=N; i++)
                {
                        if(max<pair[i].x-i)
                        {
                                max=pair[i].x-i;
                        }
                }
               
                StringBuilder sb  = new StringBuilder();
                sb.append(max+1);

                System.out.println(sb);

                
        }
}

