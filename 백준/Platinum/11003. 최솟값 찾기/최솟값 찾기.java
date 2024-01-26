import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
public class Main {

        static class Node {
                public int value;
                public int index;

                Node(int value, int index)
                {
                        this.value =value;
                        this.index= index;
                }
        }
	public static void main(String[] args) throws IOException 
        {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                StringTokenizer st = new StringTokenizer(br.readLine());

                StringBuilder sb = new StringBuilder();

                int N = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                Deque<Node> mydeque = new LinkedList<>();

                st = new StringTokenizer(br.readLine());

                for(int i =0; i<N; i++)
                {
                        int now = Integer.parseInt(st.nextToken());


                        while(!mydeque.isEmpty() && mydeque.getLast().value > now)
                        {
                                mydeque.removeLast();
                        }
                        mydeque.addLast(new Node(now, i));

                        if(mydeque.getFirst().index <= i-L)
                        {
                                mydeque.removeFirst();
                        }

                        sb.append(mydeque.getFirst().value).append(" ");
                }
                
                System.out.println(sb);
        }
}

