import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


import java.io.IOException;
import java.util.*;
public class Main {
        static int N;
        static StringBuilder sb =new StringBuilder();

	public static void main(String[] args) throws IOException 
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                N = Integer.parseInt(br.readLine());

                DFS(2,1);
                DFS(3,1);
                DFS(5,1);
                DFS(7,1);

                System.out.println(sb);
        }

        static void DFS(int number ,int jarisu)
        {
                if(jarisu == N)
                {
                        if(isPrime(number))
                        {
                                sb.append(number).append("\n");
                        }
                        return;
                }

                for(int i =1; i<10; i++)
                {
                        if(i %2 ==0)
                        {
                                continue;
                        }
                        if(isPrime(number*10+i))
                        {
                                DFS(number*10+i,jarisu+1);
                        }
                }

        }


        static boolean isPrime(int n)
        {
                for(int i =2; i<=n/2; i++)
                {
                        if(n%i ==0)
                        {
                                return false;
                        }
                }
                return true;
        }

}

