import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
        
	public static void main(String[] args) throws IOException 
        {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int N = Integer.parseInt(br.readLine());

                PriorityQueue<Integer> ppq =new PriorityQueue<>(Collections.reverseOrder());
                PriorityQueue<Integer> mpq =new PriorityQueue<>();

                for(int i =0; i<N; i++)
                {
                        int n = Integer.parseInt(br.readLine());

                        if(n>0)
                        {
                                ppq.add(n);
                        }
                        else
                        {
                                mpq.add(n);
                        }
                }

                int answer =0;
                while(!ppq.isEmpty())
                {
                        int a = ppq.poll();

                        if(ppq.isEmpty())
                        {
                                answer+=a;
                                break;
                        }
                        int b = ppq.poll();

                        if(a*b>a+b)
                        {
                                answer +=a*b;
                        }
                        else
                        {
                                answer +=a;
                                ppq.add(b);
                        }
                }

                while(!mpq.isEmpty())
                {
                        int a = mpq.poll();


                        if(mpq.isEmpty())
                        {
                                answer+=a;
                                break;
                        }
                        int b = mpq.poll();

                        if(a*b>a+b)
                        {
                                answer +=a*b;

                        }
                        else
                        {
                                answer +=a;
                                mpq.add(b);
                        }
                }
                System.out.println(answer);

        }




}


