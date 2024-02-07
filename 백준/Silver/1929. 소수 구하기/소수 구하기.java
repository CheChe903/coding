import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException 
        {
                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st =new StringTokenizer(br.readLine());
                
                int start =  Integer.parseInt(st.nextToken());
                int end =  Integer.parseInt(st.nextToken());

                boolean[] arr = new boolean[end+1];

                arr[0]=true;
                arr[1]=true;
                for(int i =2; i<=end; i++)
                {      
                        if(!arr[i])
                        {
                                for(int j =i; j<=end; j+=i)
                                {
                                        arr[j]=true;
                                }
                                arr[i]=false;
                        }
                }

                StringBuilder sb =new StringBuilder();
                for(int i =start; i<=end; i++)
                {
                        if(!arr[i])
                        {
                                sb.append(i).append("\n");
                        }
                }

                System.out.println(sb);

        }
}



