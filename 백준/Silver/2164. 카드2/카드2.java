import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
public class Main {


	public static void main(String[] args) throws IOException 
        {

                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

                int N = Integer.parseInt(br.readLine());

                Deque<Integer> deque = new ArrayDeque<>();

                for(int i =1; i<=N; i++)
                {
                        deque.offerLast(i);
                }
                int remain =N;

                while(remain!=1)
                {
                        if(!deque.isEmpty())
                        {
                                deque.removeFirst();
                                remain--;


                        }

                        if(!deque.isEmpty())
                        {
                                int k= deque.pollFirst();
                                deque.offerLast(k);
                        }

                }


                System.out.println(deque.pollFirst());

               
        }
}

