import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

        static int checkArr[];
        static int myArr[];
        static int checkSecret;
        
        private static void Add(char c)
        {
                switch(c) 
                {
                        case 'A':
                                myArr[0]++;
                                if(myArr[0] == checkArr[0])
                                        checkSecret++;
                                break;
                        case 'C':
                                myArr[1]++;
                                if(myArr[1] == checkArr[1])
                                        checkSecret++;
                                break;

                        case 'G':
                                myArr[2]++;
                                if(myArr[2] == checkArr[2])
                                        checkSecret++;
                                break;

                        case 'T':
                                myArr[3]++;
                                if(myArr[3] == checkArr[3])
                                        checkSecret++;
                                break;

                                
                }
        }
        private static void Remove(char c)
        {
                switch(c) 
                {
                        case 'A':
                                
                                if(myArr[0] == checkArr[0])
                                        checkSecret--;
                                myArr[0]--;
                                break;
                        case 'C':
                                
                                if(myArr[1] == checkArr[1])
                                        checkSecret--;
                                

                                myArr[1]--;
                                break;

                        case 'G':
                                
                                if(myArr[2] == checkArr[2])
                                        checkSecret--;
                                myArr[2]--;
                                break;

                        case 'T':
                                
                                if(myArr[3] == checkArr[3])
                                        checkSecret--;
                                myArr[3]--;
                                break;

                                
                }
        }
	public static void main(String[] args) throws IOException 
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                int count =0;


                char []A = new char[N];
                
                A = br.readLine().toCharArray();
                myArr = new int[4];
                checkArr = new int[4];

                st = new StringTokenizer(br.readLine());


                for(int i =0; i<4; i++)
                {
                        checkArr[i] = Integer.parseInt(st.nextToken());

                        if(checkArr[i] ==0)
                        {
                                checkSecret++;
                        }
                }

                for(int i =0; i<M; i++)
                {
                        Add(A[i]);
                }

                if(checkSecret ==4)
                        count++;

                for(int i= M; i<N; i++)
                {
                        int j = i-M;
                        Add(A[i]);
                        Remove(A[j]);
                        if(checkSecret==4)
                                count++;
                }


                StringBuilder sb = new StringBuilder();
                sb.append(count);
                System.out.println(count);
                }


}