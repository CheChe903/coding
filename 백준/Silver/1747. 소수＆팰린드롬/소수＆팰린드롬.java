import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxSize =2000002;
        boolean []prime = new boolean[maxSize+1];

        prime[1]= true;
        for(int i = 2; i<=maxSize; i++)
        {


                if(!prime[i])
                {
                        for(int j = i+i; j<=maxSize; j+=i)
                        {
                                
                                prime[j]=true;
                        }
                        
                }
        }
        boolean check= false;
        for(int i = N; i<=maxSize; i++)
        {
                if(!prime[i])
                {
                        check=false;
                        String str = Integer.toString(i);
                        int start = 0;
                        int end = str.length()-1;
                        
                        while(start<=end)
                        {
                                if(str.charAt(start) != str.charAt(end))
                                {
                                        check=true;


                                }
                                else
                                {
                                        start++;
                                        end--;
                                }

                                if(check)
                                {
                                        break;
                                }
                                
                        }

                        if(!check)
                        {
                                System.out.println(i);
                                break;
                        }

                }
        }



    }
}
